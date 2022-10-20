/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitmentsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kemiaa
 */
public abstract class UserAccount {

    private int id;
    private int role;
    private String userName;
    private String password;

    UserAccount(int role, String username, String password) {
        this.createAccount(role, username, password);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setUserName(String UserName) {
        this.userName = UserName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public int getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    //       TO DO

    public void createAccount(int role, String username, String password) {

//       add in the Table User
        try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            String [] returnID = {"ID"};
            stmt.executeUpdate("insert into useraccount (Role, password, username) values('" + role + "', '" + password + "', '" + username + "')", returnID);
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    this.setId(rs.getInt(1));
                }
                rs.close();
            }
            System.out.println("User added");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
        
    }

//       TO DO
    public void updateAccount(int id,String password,String username) {

//       add in the Table User
        try {
            Statement stmt = RecruitmentSystem.con.createStatement();
             stmt.executeUpdate("update useraccount set password = " + password +   " where ID = '" + id + "'");
            System.out.println("User Updated");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
        
//                try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("update students set gpa = " + newGPA + "where name = '" + name + "'");
//            System.out.println("Student updated");
//        } catch (Exception e) {
//            System.err.println("DATABASE UPDATE ERROR: " + e.toString());
//        }
        
        
    }
//   TO DO

    public int logIn(String username,String password1) {

          try {
            Statement stmt = RecruitmentSystem.con.createStatement();
            ResultSet rs = stmt.executeQuery("select ID from useraccount where username = '" + username + "' AND  password = '" + password1 + "'");
            
            if (rs.first()) {
                System.out.println("Log In successfully");
                return rs.getInt(1);
                
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        
          return -1;
        
    }

}
