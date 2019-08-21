/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static main.CapstoneProject.customerArchiveList;

/**
 *
 * @author Rob
 */
public class CreditScoreTrendsController implements Initializable {
    

    @FXML
    private Label veryPoorCreditLabel;
    @FXML
    private Label fairCreditLabel;
    @FXML
    private Label goodCreditLabel;
    @FXML
    private Label veryGoodCreditLabel;
    @FXML
    private Label exceptionalCreditLabel;
    @FXML
    private Label veryPoorLikelinessLabel;
    @FXML
    private Label fairLikelinessLabel;
    @FXML
    private Label goodLikelinessLabel;
    @FXML
    private Label veryGoodLikelinessLabel;
    @FXML
    private Label exceptionalLikelinessLabel;
    @FXML
    private Label SelectedGenderLabel;
    
    @FXML
    private BarChart<?, ?> CreditChart1;
    @FXML
    private BarChart<?, ?> CreditChart2;
    
    @FXML
    private RadioButton AllGenderRadio;
    @FXML
    private RadioButton MaleGenderRadio;
    @FXML
    private RadioButton FemaleGenderRadio;
    @FXML
    private Button BackButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataPopulate("M", "F");
    }    
    
    @FXML
    void BackButtonHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
        @FXML
    void BackButtonHover(MouseEvent event) {
        BackButton.setOpacity(.7);
    }
        @FXML
    void BackButtonExit(MouseEvent event) {
        BackButton.setOpacity(1);
    }
    
    @FXML
    void AllGenderRadioHandler(ActionEvent event) {
        DataPopulate("M", "F");
        AllGenderRadio.setSelected(true);
        MaleGenderRadio.setSelected(false);
        FemaleGenderRadio.setSelected(false);
        SelectedGenderLabel.setText("All");
    }

    @FXML
    void MaleGenderRadioHandler(ActionEvent event) {
        DataPopulate("M", "M");
        AllGenderRadio.setSelected(false);
        MaleGenderRadio.setSelected(true);
        FemaleGenderRadio.setSelected(false);
        SelectedGenderLabel.setText("Male");
    }
    
    @FXML
    void FemaleGenderRadioHandler(ActionEvent event) {
        DataPopulate("F", "F");
        AllGenderRadio.setSelected(false);
        MaleGenderRadio.setSelected(false);
        FemaleGenderRadio.setSelected(true);
        SelectedGenderLabel.setText("Female");
    }
 

    private void DataPopulate(String gender1, String gender2){
        String result;
        double veryPoorCreditCount = 0;
        double fairCreditCount = 0;
        double goodCreditCount = 0;
        double veryGoodCreditCount = 0;
        double exceptionalCreditCount = 0;
        
        int veryPoorCreditClaimsCount = 0;
        int fairCreditClaimsCount = 0;
        int goodCreditClaimsCount = 0;
        int veryGoodCreditClaimsCount = 0;
        int exceptionalCreditClaimsCount = 0;
        
        int veryPoorLikelinessCount = 0;
        int fairLikelinessCount = 0;
        int goodLikelinessCount = 0;
        int veryGoodLikelinessCount = 0;
        int exceptionalLikelinessCount = 0;
        
        DecimalFormat df = new DecimalFormat("###.#");

        for(int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getGender().equals(gender1) || customerArchiveList.get(i).getGender().equals(gender2)) {
                result = customerArchiveList.get(i).getCreditHistory();
                if (result.equals("Very Poor")){
                    veryPoorCreditCount++;
                    veryPoorCreditClaimsCount += customerArchiveList.get(i).getAnnualClaims(); //adds total number of claims
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        veryPoorLikelinessCount++; // adds one to count if one or more claims
                    }
                }
                else if (result.equals("Fair")){
                    fairCreditCount++;
                    fairCreditClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        fairLikelinessCount++;
                    }
                }
                else if (result.equals("Good")){
                    goodCreditCount++;
                    goodCreditClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        goodLikelinessCount++;
                    }
                }
                else if (result.equals("Very Good")){
                    veryGoodCreditCount++;
                    veryGoodCreditClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        veryGoodLikelinessCount++;
                    }
                }
                else if (result.equals("Exceptional")){
                    exceptionalCreditCount++;
                    exceptionalCreditClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        exceptionalLikelinessCount++;
                    }
                }
            }
        }
            // Average number of claims labels
        veryPoorCreditLabel.setText(df.format(veryPoorCreditClaimsCount/veryPoorCreditCount));
        fairCreditLabel.setText(df.format(fairCreditClaimsCount/fairCreditCount));
        goodCreditLabel.setText(df.format(goodCreditClaimsCount/goodCreditCount));
        veryGoodCreditLabel.setText(df.format(veryGoodCreditClaimsCount/veryGoodCreditCount));
        exceptionalCreditLabel.setText(df.format(exceptionalCreditClaimsCount/exceptionalCreditCount));
        
            // Likeliness of claim labels
        veryPoorLikelinessLabel.setText(df.format(veryPoorLikelinessCount/veryPoorCreditCount*100) + "%");
        fairLikelinessLabel.setText(df.format(fairLikelinessCount/fairCreditCount*100) + "%");
        goodLikelinessLabel.setText(df.format(goodLikelinessCount/goodCreditCount*100) + "%");
        veryGoodLikelinessLabel.setText(df.format(veryGoodLikelinessCount/veryGoodCreditCount*100) + "%");
        exceptionalLikelinessLabel.setText(df.format(exceptionalLikelinessCount/exceptionalCreditCount*100) + "%");
       
        
        //Bar Chart 1
        
        XYChart.Series series1 = new XYChart.Series<>();
        CreditChart1.getData().clear();
        series1.getData().add(new XYChart.Data("Very Poor", veryPoorCreditClaimsCount/veryPoorCreditCount));
        series1.getData().add(new XYChart.Data("Fair", fairCreditClaimsCount/fairCreditCount));
        series1.getData().add(new XYChart.Data("Good", goodCreditClaimsCount/goodCreditCount));
        series1.getData().add(new XYChart.Data("Very Good", veryGoodCreditClaimsCount/veryGoodCreditCount));
        series1.getData().add(new XYChart.Data("Exceptional", exceptionalCreditClaimsCount/exceptionalCreditCount));
        CreditChart1.getData().addAll(series1);
        
        //Bar Chart 2
        
        XYChart.Series series2 = new XYChart.Series<>();
        CreditChart2.getData().clear();
        series2.getData().add(new XYChart.Data("Very Poor", veryPoorLikelinessCount/veryPoorCreditCount*100));
        series2.getData().add(new XYChart.Data("Fair", fairLikelinessCount/fairCreditCount*100));
        series2.getData().add(new XYChart.Data("Good", goodLikelinessCount/goodCreditCount*100));
        series2.getData().add(new XYChart.Data("Very Good", veryGoodLikelinessCount/veryGoodCreditCount*100));
        series2.getData().add(new XYChart.Data("Exceptional", exceptionalLikelinessCount/exceptionalCreditCount*100));
        CreditChart2.getData().addAll(series2);
    }
  
}