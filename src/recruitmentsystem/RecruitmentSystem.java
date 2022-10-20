/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner; 

/**
 *
 * @author Kemiaa
 */
public class RecruitmentSystem {

    /**
     * @param args the command line arguments
     */
    public static Connection con;

    public static void main(String[] args) {
        // TODO code application logic here

        
        // Create account 
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            
//            Connection of database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "recruitment_system", "root", "");    
            
            
            
            Company c =new Company(1,"Udemy1","123456","Udemy","Smart village","Udemy@gmail.com");
            Job j= new Job("Software Engineer","Coding","gradate","1/1/2020",c.getCompanyID());
            
            
            
            
//            JobSeeker karim = new JobSeeker(2 , "Abdelrahaman4", "Kodsy4", "Adnan4", 20, "karim@gmail.com", "BUE");
//            karim.updateAccount(karim.getUserID(), "1234", "karim");
//            karim.logIn("Abdelrahaman4", "Kodsy4");                     
//          karim.apply( karim.getJobSeekerID(), j.getJobID(),"1/1/2020", "yes");


   
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());

        }
        // Remove Vac
         try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            stmt.executeUpdate("DELETE FROM job WHERE ID = 2");  // ID='" + JobID + "'"
            System.out.println("Vaccancy Removed");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
         
        
          ArrayList<Job> searchResult = new ArrayList<>();
        try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM job Where name = 'Junior Software Engi'");
            while (rs.next()) {
                searchResult.add(new Job(rs.getString("name"), rs.getString("description"), rs.getString("qualification"), rs.getString("publishDate"),rs.getInt("C_ID")));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
         Iterator iterator = searchResult.iterator(); 
  
        System.out.println("Search Results "); 
  
        while (iterator.hasNext()) 
            System.out.print(iterator.next() + " "); 
  
        System.out.println(); 
    }
}
