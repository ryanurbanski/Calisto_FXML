/*
 * Pennsylvania State University
 * IST 412 - Group 4
 * Joel Sakyi, Simon Stroh, Brad Trevenen, Ryan Urbanski
 */

import Model.User;
import Model.UserList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller for the LoginView Screen
 * @author ryan
 */
public class LoginViewController implements Initializable {
    
    @FXML private Label label;
    @FXML private Label CompanyLabel;
    @FXML private Label AppLabel;
    @FXML private AnchorPane AnchorPane;
    @FXML private TextField userNameTextField;
    @FXML private TextField pwTextField;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Login Button Clicked");
        
        String un = new String("");
        String pw = new String("");
        
        un = userNameTextField.getText();
        pw = pwTextField.getText();
        
        System.out.println("The username entered was: " + un);
        System.out.println("The password entered was: " + pw);
        
        UserList ul = new UserList();
        boolean isUser = ul.authenticate(un, pw);
        if (isUser == true) {
            System.out.println("The credentials were accepted.");
            System.out.println("The main menu will be loaded next.");
        } else {
            System.out.println("Incorrect credentials. Try again.");
        }
        
        // Center the Message label
        label.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(label, 0.0);
        AnchorPane.setRightAnchor(label, 0.0);
        label.setAlignment(Pos.CENTER);
        
        label.setText("You will soon be taken to the Main Menu");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
