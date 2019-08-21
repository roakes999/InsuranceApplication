/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rob
 */
public class FeedbackController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private Button SubmitButton;

    @FXML
    private Label ThanksLabel;
    
    @FXML
    private TextArea QuestionsField;
    
    @FXML
    private TextField EmailField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
    @FXML
    void BackButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void SubmitButtonHandler(ActionEvent event) {
        String userFeedback;
        String userEmail;
        
        if (QuestionsField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Please enter a question or comment.");
            alert.showAndWait();
        }
        else {
            userFeedback = QuestionsField.getText();
            if (EmailField.getText().isEmpty()){
                userEmail = "N/A";
            }
            else {
                userEmail = EmailField.getText();
            }
            QuestionsField.clear();
            EmailField.clear();
            
            ThanksLabel.setText("Thanks for your feedback!");
        }
        
    }

    @FXML
    void SubmitButtonHover(MouseEvent event) {
        SubmitButton.setOpacity(.7);
    }
    @FXML
    void SubmitButtonExit(MouseEvent event) {
        SubmitButton.setOpacity(1);
    }
    @FXML
    void BackButtonHover(MouseEvent event) {
        BackButton.setOpacity(.7);
    }
    @FXML
    void BackButtonExit(MouseEvent event) {
        BackButton.setOpacity(1);
    }
}
