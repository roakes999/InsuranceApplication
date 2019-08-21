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
public class VehicleTypeHPTrendsController implements Initializable {
    

    @FXML
    private Label _150Label;
    @FXML
    private Label _150_300Label;
    @FXML
    private Label _300Label;
    @FXML
    private Label _150LikelinessLabel;
    @FXML
    private Label _150_300LikelinessLabel;
    @FXML
    private Label _300LikelinessLabel;
    
    @FXML
    private Label SelectedGenderLabel;
    @FXML
    private Label SelectedVehicleLabel;
    
    @FXML
    private BarChart<?, ?> VehicleTypeHPChart1;
    @FXML
    private BarChart<?, ?> VehicleTypeHPChart2;
    
    @FXML
    private RadioButton AllGenderRadio;
    @FXML
    private RadioButton MaleGenderRadio;
    @FXML
    private RadioButton FemaleGenderRadio;
    
    @FXML
    private Button BackButton;
    
    @FXML
    private RadioButton AllVehicleRadio;
    @FXML
    private RadioButton CarRadio;
    @FXML
    private RadioButton VanRadio;
    @FXML
    private RadioButton UtilityRadio;
    @FXML
    private RadioButton TruckRadio;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataPopulate("M", "F", "Car", "Van", "Utility", "Truck"); //all
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
        AllGenderRadio.setSelected(true);
        MaleGenderRadio.setSelected(false);
        FemaleGenderRadio.setSelected(false);
        SelectedGenderLabel.setText("All");
        if (AllVehicleRadio.isSelected()){
            DataPopulate("M", "F", "Car", "Van", "Utility", "Truck");
        }
        else if (CarRadio.isSelected()){
            DataPopulate("M", "F", "Car", "Car", "Car", "Car");
        }
        else if (VanRadio.isSelected()){
            DataPopulate("M", "F", "Van", "Van", "Van", "Van");
        }
        else if (UtilityRadio.isSelected()){
            DataPopulate("M", "F", "Utility", "Utility", "Utility", "Utility");
        }
        else if (TruckRadio.isSelected()){
            DataPopulate("M", "F", "Truck", "Truck", "Truck", "Truck");
        }
    }

    @FXML
    void MaleGenderRadioHandler(ActionEvent event) {
        AllGenderRadio.setSelected(false);
        MaleGenderRadio.setSelected(true);
        FemaleGenderRadio.setSelected(false);
        SelectedGenderLabel.setText("Male");
        if (AllVehicleRadio.isSelected()){
            DataPopulate("M", "M", "Car", "Van", "Utility", "Truck");
        }
        else if (CarRadio.isSelected()){
            DataPopulate("M", "M", "Car", "Car", "Car", "Car");
        }
        else if (VanRadio.isSelected()){
            DataPopulate("M", "M", "Van", "Van", "Van", "Van");
        }
        else if (UtilityRadio.isSelected()){
            DataPopulate("M", "M", "Utility", "Utility", "Utility", "Utility");
        }
        else if (TruckRadio.isSelected()){
            DataPopulate("M", "M", "Truck", "Truck", "Truck", "Truck");
        }
    }
    
    @FXML
    void FemaleGenderRadioHandler(ActionEvent event) {
        AllGenderRadio.setSelected(false);
        MaleGenderRadio.setSelected(false);
        FemaleGenderRadio.setSelected(true);
        SelectedGenderLabel.setText("Female");
        if (AllVehicleRadio.isSelected()){
            DataPopulate("F", "F", "Car", "Van", "Utility", "Truck");
        }
        else if (CarRadio.isSelected()){
            DataPopulate("F", "F", "Car", "Car", "Car", "Car");
        }
        else if (VanRadio.isSelected()){
            DataPopulate("F", "F", "Van", "Van", "Van", "Van");
        }
        else if (UtilityRadio.isSelected()){
            DataPopulate("F", "F", "Utility", "Utility", "Utility", "Utility");
        }
        else if (TruckRadio.isSelected()){
            DataPopulate("F", "F", "Truck", "Truck", "Truck", "Truck");
        }
    }
    
    @FXML
    void AllVehicleRadioHandler(ActionEvent event) {
        AllVehicleRadio.setSelected(true);
        CarRadio.setSelected(false);
        VanRadio.setSelected(false);
        UtilityRadio.setSelected(false);
        TruckRadio.setSelected(false);
        SelectedVehicleLabel.setText("All");
        if (AllGenderRadio.isSelected()){
            DataPopulate("M", "F", "Car", "Van", "Utility", "Truck");
        }
        else if (MaleGenderRadio.isSelected()){
            DataPopulate("M", "M", "Car", "Van", "Utility", "Truck");
        }
        else if (FemaleGenderRadio.isSelected()){
            DataPopulate("F", "F", "Car", "Van", "Utility", "Truck");
        }
    }
 
    @FXML
    void CarRadioHandler(ActionEvent event) {
        AllVehicleRadio.setSelected(false);
        CarRadio.setSelected(true);
        VanRadio.setSelected(false);
        UtilityRadio.setSelected(false);
        TruckRadio.setSelected(false);
        SelectedVehicleLabel.setText("Car");
        if (AllGenderRadio.isSelected()){
            DataPopulate("M", "F", "Car", "Car", "Car", "Car");
        }
        else if (MaleGenderRadio.isSelected()){
            DataPopulate("M", "M", "Car", "Car", "Car", "Car");
        }
        else if (FemaleGenderRadio.isSelected()){
            DataPopulate("F", "F", "Car", "Car", "Car", "Car");
        }
    }
    
    @FXML
    void VanRadioHandler(ActionEvent event) {
        AllVehicleRadio.setSelected(false);
        CarRadio.setSelected(false);
        VanRadio.setSelected(true);
        UtilityRadio.setSelected(false);
        TruckRadio.setSelected(false);
        SelectedVehicleLabel.setText("Van");
        if (AllGenderRadio.isSelected()){
            DataPopulate("M", "F", "Van", "Van", "Van", "Van");
        }
        else if (MaleGenderRadio.isSelected()){
            DataPopulate("M", "M", "Van", "Van", "Van", "Van");
        }
        else if (FemaleGenderRadio.isSelected()){
            DataPopulate("F", "F", "Van", "Van", "Van", "Van");
        }
    }
    
    @FXML
    void UtilityRadioHandler(ActionEvent event) {
        AllVehicleRadio.setSelected(false);
        CarRadio.setSelected(false);
        VanRadio.setSelected(false);
        UtilityRadio.setSelected(true);
        TruckRadio.setSelected(false);
        SelectedVehicleLabel.setText("Utility");
        if (AllGenderRadio.isSelected()){
            DataPopulate("M", "F", "Utility", "Utility", "Utility", "Utility");
        }
        else if (MaleGenderRadio.isSelected()){
            DataPopulate("M", "M", "Utility", "Utility", "Utility", "Utility");
        }
        else if (FemaleGenderRadio.isSelected()){
            DataPopulate("F", "F", "Utility", "Utility", "Utility", "Utility");
        }
    }
    
    @FXML
    void TruckRadioHandler(ActionEvent event) {
        AllVehicleRadio.setSelected(false);
        CarRadio.setSelected(false);
        VanRadio.setSelected(false);
        UtilityRadio.setSelected(false);
        TruckRadio.setSelected(true);
        SelectedVehicleLabel.setText("Truck");
        if (AllGenderRadio.isSelected()){
            DataPopulate("M", "F", "Truck", "Truck", "Truck", "Truck");
        }
        else if (MaleGenderRadio.isSelected()){
            DataPopulate("M", "M", "Truck", "Truck", "Truck", "Truck");
        }
        else if (FemaleGenderRadio.isSelected()){
            DataPopulate("F", "F", "Truck", "Truck", "Truck", "Truck");
        }
    }

    private void DataPopulate(String gender1, String gender2, String vehicle1, String vehicle2, String vehicle3, String vehicle4){
        int result;
        double _150Count = 0;
        double _150_300Count = 0;
        double _300Count = 0;
        
        int _150ClaimsCount = 0;
        int _150_300ClaimsCount = 0;
        int _300ClaimsCount = 0;
        
        int _150LikelinessCount = 0;
        int _150_300LikelinessCount = 0;
        int _300LikelinessCount = 0;
        
        DecimalFormat df = new DecimalFormat("###.#");

        for(int i = 0; i < customerArchiveList.size(); ++i){
            if ((customerArchiveList.get(i).getGender().equals(gender1) || customerArchiveList.get(i).getGender().equals(gender2)) && 
                    (customerArchiveList.get(i).getVehicleType().equals(vehicle1) || customerArchiveList.get(i).getVehicleType().equals(vehicle2) || 
                    customerArchiveList.get(i).getVehicleType().equals(vehicle3) || customerArchiveList.get(i).getVehicleType().equals(vehicle4))){
                result = customerArchiveList.get(i).getEngineHP();
                if (result < 150){
                    _150Count++;
                    _150ClaimsCount += customerArchiveList.get(i).getAnnualClaims(); //adds total number of claims
                    if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                        _150LikelinessCount++; // adds one to count if one or more claims
                    }
                 //   if (customerArchiveList.get(i).getVehicleType().equals("Utility") && customerArchiveList.get(i).getGender().equals("F")){
                 //       System.out.println("Female Utility under 150");
                 //   }
                }
                else if (result < 300){
                    _150_300Count++;
                    _150_300ClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                        _150_300LikelinessCount++;
                    }
                }
                else if (result >= 300){
                    _300Count++;
                    _300ClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                        _300LikelinessCount++;
                    }
                }
                else {
                    System.out.println("Unknown HP test"); //testing
                }
            }
        }
            // Average number of claims labels
        _150Label.setText(df.format(_150ClaimsCount/_150Count));
        _150_300Label.setText(df.format(_150_300ClaimsCount/_150_300Count));
        _300Label.setText(df.format(_300ClaimsCount/_300Count));
        
            // Likeliness of claim labels
        _150LikelinessLabel.setText(df.format(_150LikelinessCount/_150Count*100) + "%");
        _150_300LikelinessLabel.setText(df.format(_150_300LikelinessCount/_150_300Count*100) + "%");
        _300LikelinessLabel.setText(df.format(_300LikelinessCount/_300Count*100) + "%");
       
        System.out.println("150 Likeliness Count: " + (_150LikelinessCount)); //test
        System.out.println("150 Count: " + _150Count); //test
        
        System.out.println("150-300 Likeliness Count: " + (_150_300LikelinessCount)); //test
        System.out.println("150-300 Count: " + _150_300Count); //test
        
        System.out.println("300 Likeliness Count: " + (_300LikelinessCount)); //test
        System.out.println("300 Count: " + _300Count); //test
        System.out.println(""); //test
        //Bar Chart 1
        
        XYChart.Series series1 = new XYChart.Series<>();
        VehicleTypeHPChart1.getData().clear();
        series1.getData().add(new XYChart.Data("Under 150", _150ClaimsCount/_150Count));
        series1.getData().add(new XYChart.Data("150 - 300", _150_300ClaimsCount/_150_300Count));
        series1.getData().add(new XYChart.Data("Over 300", _300ClaimsCount/_300Count));
        VehicleTypeHPChart1.getData().addAll(series1);
        
        //Bar Chart 2
        
        XYChart.Series series2 = new XYChart.Series<>();
        VehicleTypeHPChart2.getData().clear();
        series2.getData().add(new XYChart.Data("Under 150", _150LikelinessCount/_150Count*100));
        series2.getData().add(new XYChart.Data("150 - 300", _150_300LikelinessCount/_150_300Count*100));
        series2.getData().add(new XYChart.Data("Over 300", _300LikelinessCount/_300Count*100));
        VehicleTypeHPChart2.getData().addAll(series2);
    }
  
}