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
public class MilesDrivenTrendsController implements Initializable {
    
    @FXML
    private Label _15Label;
    @FXML
    private Label _15_25Label;
    @FXML
    private Label _25Label;
    @FXML
    private Label _15LikelinessLabel;
    @FXML
    private Label _15_25LikelinessLabel;
    @FXML
    private Label _25LikelinessLabel;
    @FXML
    private Label SelectedGenderLabel;
    
    @FXML
    private BarChart<?, ?> MilesDrivenChart1;
    @FXML
    private BarChart<?, ?> MilesDrivenChart2;
    
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
        double _15Count = 0;
        double _15_25Count = 0;
        double _25Count = 0;
        
        int _15ClaimsCount = 0;
        int _15_25ClaimsCount = 0;
        int _25ClaimsCount = 0;
        
        int _15LikelinessCount = 0;
        int _15_25LikelinessCount = 0;
        int _25LikelinessCount = 0;
        
        DecimalFormat df = new DecimalFormat("###.#");

        for(int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getGender().equals(gender1) || customerArchiveList.get(i).getGender().equals(gender2)) {
                result = customerArchiveList.get(i).getMilesDrivenBucket();
                if (result.equals("<15k")){
                    _15Count++;
                    _15ClaimsCount += customerArchiveList.get(i).getAnnualClaims(); //adds total number of claims
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        _15LikelinessCount++; // adds one to count if one or more claims
                    }
                }
                else if (result.equals("15k-25k")){
                    _15_25Count++;
                    _15_25ClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        _15_25LikelinessCount++;
                    }
                }
                else if (result.equals(">25k")){
                    _25Count++;
                    _25ClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        _25LikelinessCount++;
                    }
                }
                else {
                    System.out.println("unknown");
                }
            }
        }
            // Average number of claims labels
        _15Label.setText(df.format(_15ClaimsCount/_15Count));
        _15_25Label.setText(df.format(_15_25ClaimsCount/_15_25Count));
        _25Label.setText(df.format(_25ClaimsCount/_25Count));
        
            // Likeliness of claim labels
        _15LikelinessLabel.setText(df.format(_15LikelinessCount/_15Count*100) + "%");
        _15_25LikelinessLabel.setText(df.format(_15_25LikelinessCount/_15_25Count*100) + "%");
        _25LikelinessLabel.setText(df.format(_25LikelinessCount/_25Count*100) + "%");
       
        
        //Bar Chart 1
        
        XYChart.Series series1 = new XYChart.Series<>();
        MilesDrivenChart1.getData().clear();
        series1.getData().add(new XYChart.Data("Under 15,000", _15ClaimsCount/_15Count));
        series1.getData().add(new XYChart.Data("15,000 - 25,000", _15_25ClaimsCount/_15_25Count));
        series1.getData().add(new XYChart.Data("Over 25,000", _25ClaimsCount/_25Count));
        MilesDrivenChart1.getData().addAll(series1);
        
        //Bar Chart 2
        
        XYChart.Series series2 = new XYChart.Series<>();
        MilesDrivenChart2.getData().clear();
        series2.getData().add(new XYChart.Data("Under 15,000", _15LikelinessCount/_15Count*100));
        series2.getData().add(new XYChart.Data("15,000 - 25,000", _15_25LikelinessCount/_15_25Count*100));
        series2.getData().add(new XYChart.Data("Over 25,000", _25LikelinessCount/_25Count*100));
        MilesDrivenChart2.getData().addAll(series2);
    }
  
}