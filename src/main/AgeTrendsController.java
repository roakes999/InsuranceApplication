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
public class AgeTrendsController implements Initializable {
    
    @FXML
    private Label _18Label;
    @FXML
    private Label _18_27Label;
    @FXML
    private Label _28_34Label;
    @FXML
    private Label _35_40Label;
    @FXML
    private Label _40Label;
    @FXML
    private Label _18LikelinessLabel;
    @FXML
    private Label _18_27LikelinessLabel;
    @FXML
    private Label _28_34LikelinessLabel;
    @FXML
    private Label _35_40LikelinessLabel;
    @FXML
    private Label _40LikelinessLabel;
    @FXML
    private Label SelectedGenderLabel;
    
    @FXML
    private BarChart<?, ?> AgeChart1;
    @FXML
    private BarChart<?, ?> AgeChart2;
    
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
        double _18Count = 0;
        double _18_27Count = 0;
        double _28_34Count = 0;
        double _35_40Count = 0;
        double _40Count = 0;
        
        int _18ClaimsCount = 0;
        int _18_27ClaimsCount = 0;
        int _28_34ClaimsCount = 0;
        int _35_40ClaimsCount = 0;
        int _40ClaimsCount = 0;
        
        int _18LikelinessCount = 0;
        int _18_27fairLikelinessCount = 0;
        int _28_34LikelinessCount = 0;
        int _35_40LikelinessCount = 0;
        int _40LikelinessCount = 0;
        
        DecimalFormat df = new DecimalFormat("###.#");

        for(int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getGender().equals(gender1) || customerArchiveList.get(i).getGender().equals(gender2)) {
                result = customerArchiveList.get(i).getAgeBucket();
                if (result.equals("<18")){
                    _18Count++;
                    _18ClaimsCount += customerArchiveList.get(i).getAnnualClaims(); //adds total number of claims
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        _18LikelinessCount++; // adds one to count if one or more claims
                    }
                }
                else if (result.equals("18-27")){
                    _18_27Count++;
                    _18_27ClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        _18_27fairLikelinessCount++;
                    }
                }
                else if (result.equals("28-34")){
                    _28_34Count++;
                    _28_34ClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        _28_34LikelinessCount++;
                    }
                }
                else if (result.equals("35-40")){
                    _35_40Count++;
                    _35_40ClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        _35_40LikelinessCount++;
                    }
                }
                else if (result.equals(">40")){
                    _40Count++;
                    _40ClaimsCount += customerArchiveList.get(i).getAnnualClaims();
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        _40LikelinessCount++;
                    }
                }
            }
        }
            // Average number of claims labels
        _18Label.setText(df.format(_18ClaimsCount/_18Count));
        _18_27Label.setText(df.format(_18_27ClaimsCount/_18_27Count));
        _28_34Label.setText(df.format(_28_34ClaimsCount/_28_34Count));
        _35_40Label.setText(df.format(_35_40ClaimsCount/_35_40Count));
        _40Label.setText(df.format(_40ClaimsCount/_40Count));
        
            // Likeliness of claim labels
        _18LikelinessLabel.setText(df.format(_18LikelinessCount/_18Count*100) + "%");
        _18_27LikelinessLabel.setText(df.format(_18_27fairLikelinessCount/_18_27Count*100) + "%");
        _28_34LikelinessLabel.setText(df.format(_28_34LikelinessCount/_28_34Count*100) + "%");
        _35_40LikelinessLabel.setText(df.format(_35_40LikelinessCount/_35_40Count*100) + "%");
        _40LikelinessLabel.setText(df.format(_40LikelinessCount/_40Count*100) + "%");
       
        
        //Bar Chart 1
        
        XYChart.Series series1 = new XYChart.Series<>();
        AgeChart1.getData().clear();
        series1.getData().add(new XYChart.Data("Under 18", _18ClaimsCount/_18Count));
        series1.getData().add(new XYChart.Data("18 - 27", _18_27ClaimsCount/_18_27Count));
        series1.getData().add(new XYChart.Data("28 - 34", _28_34ClaimsCount/_28_34Count));
        series1.getData().add(new XYChart.Data("35 - 40", _35_40ClaimsCount/_35_40Count));
        series1.getData().add(new XYChart.Data("Over 40", _40ClaimsCount/_40Count));
        AgeChart1.getData().addAll(series1);
        
        //Bar Chart 2
        
        XYChart.Series series2 = new XYChart.Series<>();
        AgeChart2.getData().clear();
        series2.getData().add(new XYChart.Data("Under 18", _18LikelinessCount/_18Count*100));
        series2.getData().add(new XYChart.Data("18 - 27", _18_27fairLikelinessCount/_18_27Count*100));
        series2.getData().add(new XYChart.Data("28 - 34", _28_34LikelinessCount/_28_34Count*100));
        series2.getData().add(new XYChart.Data("35 - 40", _35_40LikelinessCount/_35_40Count*100));
        series2.getData().add(new XYChart.Data("Over 40", _40LikelinessCount/_40Count*100));
        AgeChart2.getData().addAll(series2);
    }
  
}