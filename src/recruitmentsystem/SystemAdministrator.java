package recruitmentsystem;

import java.sql.Statement;

public class SystemAdministrator extends UserAccount {

    private static SystemAdministrator Admin = null;


    public SystemAdministrator(int role, String username, String password) {
        super(role, username, password);
    }

    
    public static SystemAdministrator getInstance() {

        if (Admin == null) {
            Admin = new SystemAdministrator(1,"admin","admin");
            return Admin;
        } else
            return Admin;
    }


    public String RemoveVac(int JobID) {

        JobAdmin Remove = new JobAdmin();
        Remove.RemoveVac(JobID);

        return null;
    }

    public String SuspendUser(int USERID) {

       try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            stmt.executeUpdate("DELETE FROM useraccount WHERE ID ='" + USERID + "'");
            System.out.println("User Suspended");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
         String Status = "Removed Successfully";
        return Status ;

    }

    public String ConfirmVac(int jobID) {
        String Confirm = "Vaccancy Confirmed";
        String Denied = "Vaccancy Denied";
        int min = 1;
        int max = 100000;
        if (jobID >= min && jobID <= max)
            return Confirm;
        
        else
            return Denied;
    }
}