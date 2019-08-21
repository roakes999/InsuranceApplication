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
public class MaritalStatusTrendsController implements Initializable {
    
    @FXML
    private Label SingleLabel;
    @FXML
    private Label MarriedLabel;
    @FXML
    private Label SingleLikelinessLabel;
    @FXML
    private Label MarriedLikelinessLabel;
    @FXML
    private Label SelectedGenderLabel;
    
    @FXML
    private BarChart<?, ?> MaritalStatusChart1;
    @FXML
    private BarChart<?, ?> MaritalStatusChart2;
    
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
        double SingleCount = 0;
        double MarriedCount = 0;
        
        int SingleClaimsCount = 0;
        int MarriedClaimsCount = 0;
        
        int SingleLikelinessCount = 0;
        int MarriedLikelinessCount = 0;
        
        DecimalFormat df = new DecimalFormat("###.#");

        for(int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getGender().equals(gender1) || customerArchiveList.get(i).getGender().equals(gender2)) {
                result = customerArchiveList.get(i).getMaritalStatus();
                if (result.equals("Single")){
                    SingleCount++;
                    SingleClaimsCount += customerArchiveList.get(i).getAnnualClaims(); //adds total number of claims
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        SingleLikelinessCount++; // adds one to count if one or more claims
                    }
                }
                else if (result.equals("Married")){
                    MarriedCount++;
                    MarriedClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        MarriedLikelinessCount++;
                    }
                }
                else{
                    System.out.println("unknown");
                }
            }
        }
            // Average number of claims labels
        SingleLabel.setText(df.format(SingleClaimsCount/SingleCount));
        MarriedLabel.setText(df.format(MarriedClaimsCount/MarriedCount));
        
            // Likeliness of claim labels
        SingleLikelinessLabel.setText(df.format(SingleLikelinessCount/SingleCount*100) + "%");
        MarriedLikelinessLabel.setText(df.format(MarriedLikelinessCount/MarriedCount*100) + "%");
       
        
        //Bar Chart 1
        
        XYChart.Series series1 = new XYChart.Series<>();
        MaritalStatusChart1.getData().clear();
        series1.getData().add(new XYChart.Data("Single", SingleClaimsCount/SingleCount));
        series1.getData().add(new XYChart.Data("Married", MarriedClaimsCount/MarriedCount));
        MaritalStatusChart1.getData().addAll(series1);
        
        //Bar Chart 2
        
        XYChart.Series series2 = new XYChart.Series<>();
        MaritalStatusChart2.getData().clear();
        series2.getData().add(new XYChart.Data("Single", SingleLikelinessCount/SingleCount*100));
        series2.getData().add(new XYChart.Data("Married", MarriedLikelinessCount/MarriedCount*100));
        MaritalStatusChart2.getData().addAll(series2);
    }
  
}