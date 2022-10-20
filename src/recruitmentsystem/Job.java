/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitmentsystem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ahmed Kamal
 */
public class Job {

    private int JobID; // Job ID
    private String JobName; // Job Title
    private String JobDesc; // Description
    private String JobQual; // Qualifications
    private String JobPD; // Publish date
    private ArrayList<JobSubject> observerList;

    public Job() {
    }

    
    public Job(String JobName, String JobDesc, String JobQual, String JobPD,int companyID) {
        this.createJob(JobName, JobDesc, JobQual, JobPD, companyID);
        this.JobName = JobName;
        this.JobDesc = JobDesc;
        this.JobQual = JobQual;
        this.JobPD = JobPD;
            
    }
    

    public int getJobID() {
        return JobID;
    }

    public void setJobID(int jobID) {
        JobID = jobID;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public String getJobDesc() {
        return JobDesc;
    }

    public void setJobDesc(String jobDesc) {
        JobDesc = jobDesc;
    }

    public String getJobQual() {
        return JobQual;
    }

    public void setJobQual(String jobQual) {
        JobQual = jobQual;
    }

    public String getJobPD() {
        return JobPD;
    }

    public void setJobPD(String jobPD) {
        JobPD = jobPD;
    }

    public ArrayList<JobSubject> getObserverList() {
        return observerList;
    }

    public void setObserverList(ArrayList<JobSubject> observerList) {
        this.observerList = observerList;
    }
    
    public void createJob(String name,String jobDesc,String jobQual,String jobPD,int companyID){

     String [] returnID = {"JobID"};
         try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            stmt.executeUpdate("insert into Job (name, description, qualification, publishDate, C_ID ) values('" + name + "', '" + jobDesc +  "', '" + jobQual +  "','" + jobPD +"','" + companyID + "')", returnID);
            System.out.println("Job is Added");
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    this.setJobID(rs.getInt(1));
                }
                rs.close();
            }
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        } 
    
}

    public ArrayList<Job> SearchForJob(String Name) {
        
     ArrayList<Job> searchResult = new ArrayList<>();
        try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM job Where name = 'Junior Software Engi'");
            while (rs.next()) {
                searchResult.add(new Job (rs.getString("name"), rs.getString("description"), rs.getString("qualification"), rs.getString("publishDate"),rs.getInt("C_ID")));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
         Iterator iterator = searchResult.iterator(); 
  
        System.out.println("Search Results "); 
  
        while (iterator.hasNext()) 
            System.out.print(iterator.next() + " "); 
  
        System.out.println(); 
        return null;
    }

    public void UpdateJob(String Name, String Desc, String Qual, String Publish) {

          String [] returnID = {"JobID"};
         try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            stmt.executeUpdate("update job set name = '" + Name + "',description = '" + Desc +  "', qualification = '" + Qual +  "', publishDate = '" + Publish +"'");
            System.out.println("Job Updated");
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    this.setJobID(rs.getInt(1));
                }
                rs.close();
            }
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        } 
    }

}
