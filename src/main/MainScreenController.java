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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rob
 */
public class MainScreenController implements Initializable {

    @FXML
    private Button CreditScoreButton;
    @FXML
    private Button AgeButton;
    @FXML
    private Button MaritalStatusButton;
    @FXML
    private Button VehicleTypeHPButton;
    @FXML
    private Button MilesDrivenButton;
    @FXML
    private Button StateButton;
    @FXML
    private Button AnalyzeButton;
    @FXML
    private Button LogoutButton;
    @FXML
    private Button FeedbackButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
    }    
    
    // mouse enter and exit actions of buttons
    @FXML
    void CreditScoreButtonHover(MouseEvent event) {
        CreditScoreButton.setOpacity(.7);
    }
    @FXML
    void CreditScoreButtonExit(MouseEvent event) {
        CreditScoreButton.setOpacity(1);
    }
    @FXML
    void AgeButtonHover(MouseEvent event) {
        AgeButton.setOpacity(.7);
    }
    @FXML
    void AgeButtonExit(MouseEvent event) {
        AgeButton.setOpacity(1);
    }
    @FXML
    void MaritalStatusButtonHover(MouseEvent event) {
        MaritalStatusButton.setOpacity(.7);
    }
    @FXML
    void MaritalStatusButtonExit(MouseEvent event) {
        MaritalStatusButton.setOpacity(1);
    }
    @FXML
    void MilesDrivenButtonHover(MouseEvent event) {
        MilesDrivenButton.setOpacity(.7);
    }
    @FXML
    void MilesDrivenButtonExit(MouseEvent event) {
        MilesDrivenButton.setOpacity(1);
    }
    @FXML
    void VehicleTypeHPButtonHover(MouseEvent event) {
        VehicleTypeHPButton.setOpacity(.7);
    }
    @FXML
    void VehicleTypeHPButtonExit(MouseEvent event) {
        VehicleTypeHPButton.setOpacity(1);
    }
    @FXML
    void StateButtonHover(MouseEvent event) {
        StateButton.setOpacity(.7);
    }
    @FXML
    void StateButtonExit(MouseEvent event) {
        StateButton.setOpacity(1);
    }
    @FXML 
    void AnalyzeButtonHover(MouseEvent event) {
        AnalyzeButton.setOpacity(.7);
    }
    @FXML
    void AnalyzeButtonExit(MouseEvent event) {
        AnalyzeButton.setOpacity(1);
    }
    @FXML 
    void LogoutButtonHover(MouseEvent event) {
        LogoutButton.setOpacity(.7);
    }
    @FXML
    void LogoutButtonExit(MouseEvent event) {
        LogoutButton.setOpacity(1);
    }
    @FXML 
    void FeedbackButtonHover(MouseEvent event) {
        FeedbackButton.setOpacity(.7);
    }
    @FXML
    void FeedbackButtonExit(MouseEvent event) {
        FeedbackButton.setOpacity(1);
    }

    // scene change buttons
    @FXML
    void CreditScoreButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreditScoreTrends.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void AgeButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AgeTrends.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void MaritalStatusButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MaritalStatusTrends.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void VehicleTypeHPButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VehicleTypeHPTrends.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void MilesDrivenButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MilesDrivenTrends.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void StateButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StateTrends.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void AnalyzeButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Analyze.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void LogoutButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    @FXML
    void FeedbackButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Feedback.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
