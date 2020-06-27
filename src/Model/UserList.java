/*
 * Pennsylvania State University
 * IST 412 - Group 4
 * Joel Sakyi, Simon Stroh, Brad Trevenen, Ryan Urbanski
 */

package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Contains a list of all authorized usernames and passwords.
 * @author ryan
 */
public class UserList {
    
    ArrayList<User> listOfUsers = new ArrayList<User>();
    String listOfUsersFileName = "listOfUsers.ser";     // Name of file for persistence
    
    public UserList() {
        this.readUserListFile();
        if (listOfUsers.isEmpty() || listOfUsers == null) {
            this.createTestUserList();
            this.writeUserListFile();
            this.readUserListFile();
        }
        
    }
    
    /**
     * Reads the User List from a persistent data file
     */
    public void readUserListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        
        try {
            fis = new FileInputStream(listOfUsersFileName);
            in = new ObjectInputStream(fis);
            listOfUsers = (ArrayList<User>) in.readObject();
            in.close();
            if (!listOfUsers.isEmpty()) {
                System.out.println("There are users in the list file");
            } 
            
        }  catch (IOException ex) {
            ex.printStackTrace();
        }  catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Writes new user data to the persistent file
     */
    public void writeUserListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        
        try {
            fos = new FileOutputStream(listOfUsersFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfUsers);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Creates the userlist file
     * This will be modified in the future to allow users 
     * to create a new account in the login screen
     */
    public void createTestUserList() {
        
        listOfUsers.add(new User("ryan", "1234"));
        listOfUsers.add(new User("joel", "1234"));
        listOfUsers.add(new User("simon", "1234"));
        listOfUsers.add(new User("brad", "1234"));
        
        System.out.println("Test UserList created");
        System.out.println("The UserList is: " + listOfUsers);
    }
    
    /**
     * Tests that data is Persistent
     */
    public void printUserList() {
        System.out.println("The UserList has these users:");
        for (int i = 0; i < listOfUsers.size(); i++) {
            User currentUser = (User) listOfUsers.get(i);
            System.out.println(currentUser.getUsername() + ", " + currentUser.
                    password);
        }
    }
    
    /**
     * Takes a username and password and returns TRUE if they are in UserList
     *
     * @param username
     * @param password
     * @return
     */
    public boolean authenticate(String username, String password) {

        for (User user : listOfUsers) {

            if (user.getUsername().equalsIgnoreCase(username)
                    && user.getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }
    
}
