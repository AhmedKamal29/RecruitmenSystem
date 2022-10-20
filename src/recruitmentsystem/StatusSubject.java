/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitmentsystem;

/**
 *
 * @author Kemiaa
 */
public interface StatusSubject {
 
  public void updateAll(int applicationID);
 public void RegisterObserver(int jobSeeker, int applicationID);
  public void UnRegisterObserber(int JobSeekerID);
    
}
