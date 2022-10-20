/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitmentsystem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ahmed Kamal
 */
public class Company extends UserAccount {
    private int companyID;
    private String Name;
    private String Location;
    private String Email;
    private ArrayList<Job> Vaccancies;
    private ArrayList<JobSeeker> Visitors;

  
    public Company(int role, String username, String password,String Name, String Location, String Email ) {
        super(role, username, password);
        
             this.createCompanyAccount(Name, Location, Email, super.getId());
        
        this.Name = Name;
        this.Location = Location;
        this.Email = Email;
        this.Vaccancies = Vaccancies;
        this.Visitors = Visitors;
    }
   
    
      public void createCompanyAccount(String name,String location,String Email, int userID) {
 String [] returnID = {"CompanyID"};
         try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            stmt.executeUpdate("insert into Company (name, location, email, U_ID) values('" + name + "', '" + location +  "', '" + Email +  "','" + userID + "')", returnID);
            System.out.println("Company is Added");
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    this.setCompanyID(rs.getInt(1));
                }
                rs.close();
            }
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }       
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getCompanyID() {
        return companyID;
    }
    

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setVaccancies(ArrayList<Job> Vaccancies) {
        this.Vaccancies = Vaccancies;
    }

    public void setExperince(ArrayList<JobSeeker> Visitors) {
        this.Visitors = Visitors;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public String getEmail() {
        return Email;
    }

    public ArrayList<Job> getVaccancies() {
        return Vaccancies;
    }

    public ArrayList<JobSeeker> getVisitors() {
        return Visitors;
    }

    public String RemoveVac(int JobID) {
         try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            stmt.executeUpdate("DELETE FROM job WHERE ID ='" + JobID + "'");
            System.out.println("Vaccancy Removed");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
         String Status = "Removed Successfully";
        return Status ;
    }

    public Job PostVacanies(String name, String desc, String qual, String publish, int CID) {
        
        Job job = new Job(name, desc, qual, publish, this.companyID);
        return job;
    }
    
    public Application getApplicationByID(int ApplicationID){
    
        Application temp;
                 try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from application where ID = '" + ApplicationID + "'");
            
            if (rs.next()) {
                temp = new Application (rs.getInt("ID"), rs.getInt("jobSeekerID"), rs.getInt("jobID"),rs.getString("status"));
               return temp ;
            }
            
      
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        
             return null; 
    }
    
   public void ManageStatus(int ApplicationID){
       
      try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            ResultSet app = stmt.executeQuery("SELECT jobSeekerID FROM application Where ID = '" + ApplicationID + "'");
             int JobSeekerID = app.getInt(2);
             
            ResultSet js = stmt.executeQuery("SELECT education FROM jobseeker Where ID = '" + JobSeekerID + "'");
            String Education = js.getString(5);
            
            
            String[] avEducations = new String[]{"BUE", "GUC", "AUC","FUE","MSA","MUST"};
            List<String> list = Arrays.asList(avEducations);
            boolean confirm;
            
             stmt.executeUpdate("update Application set status = " + " yes" +   " where ID = '" + ApplicationID + "'");
                System.out.println("Status Updated");
              
              
            if(list.contains(Education)){
            confirm = true;
                ConfirmationString(confirm);
                Application application = getApplicationByID(ApplicationID);
                application.updateAll(ApplicationID);
                
            }
            else {
            confirm = false;
                ConfirmationString(confirm);
            }
            
             
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        
   }
   
   public String ConfirmationString(boolean confirmation){
       
       String ConfimrationMassage = "You have been successfully accepted For the the applied Job, Please Conatct the Company for further demonstration";
       
       if (confirmation== true){
           return ConfimrationMassage;
       }
       else 
           return ConfimrationMassage;
       
   }
}
