/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rob
 */
public class LoginController implements Initializable {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField UsernameField;

    @FXML
    private TextField PasswordField;
    
    public static ArrayList<UserLoginInfo> userLoginList = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UsernameField.setText("test"); // FOR PROGRAM EVALUATION ONLY(pre-filled username)
        PasswordField.setText("test"); // FOR PROGRAM EVALUATION ONLY(pre-filled password)
        
        populateLoginList();
    }    
    
    private static void populateLoginList(){
        userLoginList.add(new UserLoginInfo("test", "test"));
        userLoginList.add(new UserLoginInfo("rob", "1234"));
    }

    @FXML
    void LoginButtonHandler(ActionEvent event) throws IOException {
                
        String usernameValue = UsernameField.getText();
        String passwordValue = PasswordField.getText();
        boolean correctLoginInfo = false;
        
        if (usernameValue.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Please enter a username.");
            alert.showAndWait();
        }
        else if (passwordValue.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Please enter a password.");
            alert.showAndWait();
        }
        else {
            for (int i = 0; i < userLoginList.size(); ++i){
                if ((usernameValue.equals(userLoginList.get(i).getUsername())) && (passwordValue.equals(userLoginList.get(i).getPassword()))){
                    correctLoginInfo = true;
                }
            }
            if (correctLoginInfo == true){
                Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("An invalid Username or Password was entered.");
                alert.showAndWait();
            }
        }
    }
    
    @FXML
    void LoginButtonExit(MouseEvent event) {
        LoginButton.setOpacity(1);
    }

    @FXML
    void LoginButtonHover(MouseEvent event) {
        LoginButton.setOpacity(.7);
    }
}
