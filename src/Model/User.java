/*
 * Pennsylvania State University
 * IST 412 - Group 4
 * Joel Sakyi, Simon Stroh, Brad Trevenen, Ryan Urbanski
 */

package Model;

import java.io.Serializable;

/**
 * Contains Login Information for User Account
 * @author ryan
 */
public class User implements Serializable {
    
    String username;
    String password;
    
    /**
     * Creates a user account object with a username and password
     * @param un
     * @param pw 
     */
    public User(String un, String pw) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * Retrieves username
     * @return 
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Retrieves password
     * @return 
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Displays username and password as a string
     * @return 
     */
    public String toString() {
        return username + ", " + password;
    }
    
}
