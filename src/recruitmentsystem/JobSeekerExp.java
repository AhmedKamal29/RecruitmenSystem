/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitmentsystem;

import java.util.ArrayList;

/**
 *
 * @author Kemiaa
 */
public class JobSeekerExp {
    int numOfyears;
    String companyName;
    String title;
    ArrayList<String> skills;

    public JobSeekerExp(int numOfyears, String companyName, String title, ArrayList<String> skills) {
        this.numOfyears = numOfyears;
        this.companyName = companyName;
        this.title = title;
        this.skills = skills;
    }

    public void setNumOfyears(int numOfyears) {
        this.numOfyears = numOfyears;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public int getNumOfyears() {
        return numOfyears;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }


    
    
}
