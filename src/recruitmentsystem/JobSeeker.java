/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitmentsystem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kemiaa
 */

public class JobSeeker extends UserAccount implements JobSeekerJobObserver {
    private int jobSeekerID;
    private String name;
    private int age;
    private String email;
    private String education;
    private ArrayList<JobSeekerExp>experince;
    private int userID;
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public int getUserID(){
        return this.userID;
    }

    public JobSeeker(int role,String username, String password, String name, int age, String email, String education) {

        super(role, username, password);
        //Add Record to Database
        this.createJobSeekerAccount(name, age, email, education, super.getId());
        
        this.age = age;
        this.userID = super.getId();
        this.education = education;
        this.name = name;
        this.email = email;
    }
    
    
        public void createJobSeekerAccount(String name, int age, String email, String education, int userID){
        String [] returnID = {"jobSeekerID"};
         try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            stmt.executeUpdate("insert into jobseeker (name, age, email, education, U_ID) values('" + name + "', '" + age+  "', '" + email + "', '" + education + "','" + userID + "')", returnID);
            System.out.println("Job Seeker is Added");
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    this.setJobSeekerID(rs.getInt(1));
                }
                rs.close();
            }
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }         
    }
    
    
    
    
    public void setJobSeekerID(int id){
        this.jobSeekerID = id;
    }
    
    public int getJobSeekerID(){
        return this.jobSeekerID;
    }
    
    

 
    
    public JobSeeker(int role,String username,String password,String name, int age, String education, ArrayList<JobSeekerExp> experince) {
   super(role, username, password);

        this.name = name;
        this.age = age;
        this.education = education;
        this.experince = experince;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getEducation() {
        return education;
    }

    public ArrayList<JobSeekerExp> getExperince() {
        return experince;
    }    
 
   
   public void apply( int jobSeekerID,int jobID,String Date,String status){
//   Application application= new Application( id, jobSeekerID,  jobID, status);
   
   // add application record in application table
  
        try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            stmt.executeUpdate("insert into application ( jobSeekerID, jobID,Date,status) values('" + jobSeekerID + "', '" + jobID+  "', '" + Date +"', '" + status + "')");
            System.out.println("application added");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
   
   }
   
public void publishExperience(int numOfyears,String companyName,String title,  ArrayList<String> skills)
{

//       Add Exp in table JobSeekerExp
    
    /*
    
        public void addStudent(Student s) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into students values('" + s.getName() + "', " + s.getGPA() + ")");
            System.out.println("Student added");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }
    
    */
    
}  

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setExperince(ArrayList<JobSeeker> experince) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
