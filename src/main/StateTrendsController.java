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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static main.CapstoneProject.customerArchiveList;

/**
 *
 * @author Rob
 */
public class StateTrendsController implements Initializable {
    
    ObservableList<String> DropDownStateList = FXCollections.observableArrayList("AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE",
            "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE",
            "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY");

    @FXML
    private Label StateNameGrid;

    @FXML
    private Label AllStatesLabel;

    @FXML
    private Label SelectedStateGridLabel;

    @FXML
    private Label AllStatesLikelinessLabel;

    @FXML
    private Label SelectedStateGridLikelinessLabel;

    @FXML
    private BarChart<?, ?> StateChart1;

    @FXML
    private Button BackButton;

    @FXML
    private BarChart<?, ?> StateChart2;

    @FXML
    private Label SelectedStateBlueLabel;

    @FXML
    private ComboBox<String> StateDropDown;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PopulateDropDown();
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
    void StateDropDownHandler(ActionEvent event) {
        DataPopulate(StateDropDown.getValue());
        SelectedStateBlueLabel.setText(StateDropDown.getValue());
        StateNameGrid.setText(StateDropDown.getValue());
    } 

    private void DataPopulate(String state){
        String result;
        double selectedStateCount = 0;
        double overallStateCount = 0;
        
        int selectedStateClaimsCount = 0;
        int overallStateClaimsCount = 0;
        
        int selectedStateLikelinessCount = 0;
        int overallStateLikelinessCount = 0;
        
        DecimalFormat df = new DecimalFormat("###.#");

        for(int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getState().equals(state)) {
                    selectedStateCount++;
                    selectedStateClaimsCount += customerArchiveList.get(i).getAnnualClaims(); //adds total number of claims
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        selectedStateLikelinessCount++; // adds one to count if one or more claims
                    }
            }
            overallStateCount++;
                    overallStateClaimsCount += customerArchiveList.get(i).getAnnualClaims(); //adds total number of claims
                    if (customerArchiveList.get(i).getAnnualClaims() > 1){
                        overallStateLikelinessCount++; // adds one to count if one or more claims
                    }
        }
            // Average number of claims labels
        AllStatesLabel.setText(df.format(overallStateClaimsCount/overallStateCount));
        SelectedStateGridLabel.setText(df.format(selectedStateClaimsCount/selectedStateCount));
        
            // Likeliness of claim labels
        AllStatesLikelinessLabel.setText(df.format(overallStateLikelinessCount/overallStateCount*100) + "%");
        SelectedStateGridLikelinessLabel.setText(df.format(selectedStateLikelinessCount/selectedStateCount*100) + "%");
       
        
        //Bar Chart 1
        
        XYChart.Series series1 = new XYChart.Series<>();
        StateChart1.getData().clear();
        series1.getData().add(new XYChart.Data("All States", overallStateClaimsCount/overallStateCount));
        series1.getData().add(new XYChart.Data(state, selectedStateClaimsCount/selectedStateCount));
        StateChart1.getData().addAll(series1);
        
        //Bar Chart 2
        
        XYChart.Series series2 = new XYChart.Series<>();
        StateChart2.getData().clear();
        series2.getData().add(new XYChart.Data("All States", overallStateLikelinessCount/overallStateCount*100));
        series2.getData().add(new XYChart.Data(state, selectedStateLikelinessCount/selectedStateCount*100));
        StateChart2.getData().addAll(series2);
    }
    
    private void PopulateDropDown() {
        
        StateDropDown.setItems(DropDownStateList);
    }
  
}