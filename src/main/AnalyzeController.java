/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Year;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static main.CapstoneProject.customerArchiveList;

/**
 * FXML Controller class
 *
 * @author Rob
 */
public class AnalyzeController implements Initializable {

    @FXML
    private Button BackButton;
    @FXML
    private Button RunAnalysisButton;
    @FXML
    private Label GenderLabel;
    @FXML
    private ComboBox<String> GenderDropDown;
    @FXML
    private Label DateOfBirthLabel;
    @FXML
    private Label MaritalStatusLabel;
    @FXML
    private ComboBox<String> MaritalStatusDropDown;
    @FXML
    private Label VehicleTypeLabel;
    @FXML
    private ComboBox<String> VehicleTypeDropDown;
    @FXML
    private Label HorsepowerLabel;
    @FXML
    private Label CreditScoreLabel;
    @FXML
    private Label AnnualMilesDrivenLabel;
    @FXML
    private Label StateLabel;
    @FXML
    private ComboBox<String> StateDropDown;
    @FXML
    private TextField CreditScoreField;
    @FXML
    private TextField HorsepowerField;
    @FXML
    private TextField AnnualMilesDrivenField;
    @FXML
    private DatePicker DateOfBirthPicker;
    @FXML
    private ImageView arrow;
    @FXML
    private Label RiskLabel;
    @FXML
    private Label arrowText;
    @FXML
    private Label insurancePremiumLabel;
    @FXML
    private Label insurancePremiumMonthlyLabel;
    @FXML
    private Label annualClaimsLabel;
    @FXML
    private Label likelinessOfClaimsLabel;
    
    
    
    ObservableList<String> DropDownGenderList = FXCollections.observableArrayList("Male", "Female");
    ObservableList<String> DropDownAgeList = FXCollections.observableArrayList();
    ObservableList<String> DropDownMaritalStatusList = FXCollections.observableArrayList("Single", "Married");
    ObservableList<String> DropDownVehicleTypeList = FXCollections.observableArrayList("Car", "Van", "Utility", "Truck");
    ObservableList<String> DropDownStateList = FXCollections.observableArrayList("AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE",
        "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE",
        "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY");
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
        PopulateDropDowns();
        arrow.setVisible(false);
        arrowText.setVisible(false);
        
        // FOR TESTING set values
      /*  GenderDropDown.setValue("Male"); //TEST
        DateOfBirthPicker.setValue(LocalDate.now()); //TEST
        MaritalStatusDropDown.setValue("Single"); //TEST
        VehicleTypeDropDown.setValue("Car"); //TEST
        StateDropDown.setValue("AZ"); //TEST
        HorsepowerField.setText("300"); //TEST
        CreditScoreField.setText("300"); //TEST
        AnnualMilesDrivenField.setText("300"); //TEST
        */
    } 
    
    private void PopulateDropDowns() {
        GenderDropDown.setItems(DropDownGenderList);
        MaritalStatusDropDown.setItems(DropDownMaritalStatusList);
        VehicleTypeDropDown.setItems(DropDownVehicleTypeList);
        StateDropDown.setItems(DropDownStateList);
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
    void DateOfBirthHandler(ActionEvent event) {
        DateOfBirthLabel.setText(DateOfBirthPicker.getValue().toString());
    }

    @FXML
    void GenderDropDownHandler(ActionEvent event) {
        GenderLabel.setText(GenderDropDown.getValue());
    }

    @FXML
    void MaritalStatusDropDownHandler(ActionEvent event) {
        MaritalStatusLabel.setText(MaritalStatusDropDown.getValue());
    }

    @FXML
    void StateDropDownHandler(ActionEvent event) {
        StateLabel.setText(StateDropDown.getValue());
    }

    @FXML
    void VehicleTypeDropDownHandler(ActionEvent event) {
        VehicleTypeLabel.setText(VehicleTypeDropDown.getValue());
    }
    
    @FXML
        void HorsepowerHandler(KeyEvent event) {
        HorsepowerLabel.setText(HorsepowerField.getText());
    }   
    @FXML
        void CreditScoreHandler(KeyEvent event) {
        CreditScoreLabel.setText(CreditScoreField.getText());
    } 
    @FXML
        void AnnualMilesDrivenHandler(KeyEvent event) {
        AnnualMilesDrivenLabel.setText(AnnualMilesDrivenField.getText());
    }
    
    @FXML 
    void RunAnalysisButtonHover(MouseEvent event) {
        RunAnalysisButton.setOpacity(.7);
    }
    @FXML
    void RunAnalysisButtonExit(MouseEvent event) {
        RunAnalysisButton.setOpacity(1);
    }
    
    
    @FXML
    void RunAnalysisButtonHandler(ActionEvent event) {                    
             
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat df2 = new DecimalFormat("###.#");
        double overallRisk = 0;
        double RISK_MAX = 1.25; // risk factor max (if risk factor is above the max, it will still display on the graph, but no higher than the max position)
        double RISK_MIN = 0.82; // risk factor min
        double arrowMaxY = 234; // highest arrow location in the y direction on risk level meter
        double arrowMinY = 705; // lowest arrow location in the y direction on risk level meter
        double riskRange = RISK_MAX - RISK_MIN;
        double arrowRange = arrowMinY - arrowMaxY;
        double arrowLocation;
        double MIN_PREMIUM = 800; // minimum insurance premium
        double MAX_PREMIUM = 2200; // maximum insurance premium
        double premiumRange = MAX_PREMIUM - MIN_PREMIUM;
        double overallRiskPercent;
        double insurancePremium;
        double overallLikeliness;
        double overallNumberOfClaims;
        
        try {
            if ((GenderDropDown.getValue() == null) ||  (DateOfBirthPicker.getValue() == null)
                    ||  (MaritalStatusDropDown.getValue() == null) ||  (StateDropDown.getValue() == null)
                    ||  (VehicleTypeDropDown.getValue() == null) ||  (HorsepowerField.getText().isEmpty())
                    ||  (CreditScoreField.getText().isEmpty()) ||  (AnnualMilesDrivenField.getText().isEmpty())) {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Missing Information");
                alert1.setHeaderText("Please make a selection for all fields.");
                alert1.showAndWait();
            }
            else if ((Integer.parseInt(CreditScoreField.getText()) < 300) || (Integer.parseInt(CreditScoreField.getText()) > 850)){
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Error");
                alert2.setHeaderText("Credit score must be between 300 and 850.");
                alert2.showAndWait();
            }
            else if ((LocalDate.now().getYear() - DateOfBirthPicker.getValue().getYear()) < 16){
                Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                alert3.setTitle("Error");
                alert3.setHeaderText("Customer must be age 16 or over.");
                alert3.showAndWait();
            }
            else {
                    overallRisk = (GenderRiskCalculate(GenderDropDown.getValue())[0] + DateOfBirthRiskCalculate(DateOfBirthPicker.getValue().getYear())[0]
                            + MaritalStatusRiskCalculate(MaritalStatusDropDown.getValue())[0] + VehicleTypeRiskCalculate(VehicleTypeDropDown.getValue())[0]
                            + EngineHPRiskCalculate(Integer.parseInt(HorsepowerField.getText()))[0] + CreditScoreRiskCalculate(Integer.parseInt(CreditScoreField.getText()))[0]
                            + AnnualMilesDrivenRiskCalculate(Integer.parseInt(AnnualMilesDrivenField.getText()))[0]
                            + StateRiskCalculate(StateDropDown.getValue())[0])/8;

                    //RiskLabel.setText(df.format(overallRisk));
                    
                    //Set arrow and arrow text location
                    
                    if (overallRisk < RISK_MIN){
                        arrowLocation = arrowMinY;
                        arrow.setLayoutY(arrowLocation);
                        arrowText.setLayoutY(arrowMinY + 10); // offset of 10 to line up with arrow
                        arrowText.setText("Very Low");
                    }
                    else if (overallRisk > RISK_MAX){
                        arrowLocation = arrowMaxY;
                        arrow.setLayoutY(arrowLocation);
                        arrowText.setLayoutY(arrowMaxY + 10);
                        arrowText.setText("Very High");

                    }
                    else {
                        arrowLocation = arrowMinY - (((overallRisk - RISK_MIN)/riskRange) * arrowRange);
                        arrow.setLayoutY(arrowLocation);
                        arrowText.setLayoutY(arrowLocation + 10);
                    }
                    
                    //Set arrow text
                    
                    if ((arrowMinY - arrowLocation) < (0.2 * arrowRange)){
                        arrowText.setText("Very Low");
                    }
                    else if ((arrowMinY - arrowLocation) < (0.4 * arrowRange)){
                        arrowText.setText("Low");
                    }
                    else if ((arrowMinY - arrowLocation) < (0.6 * arrowRange)){
                        arrowText.setText("Medium");
                    }
                    else if ((arrowMinY - arrowLocation) < (0.8 * arrowRange)){
                        arrowText.setText("High");
                    }
                    else {
                        arrowText.setText("Very High");
                    }
                    
                    
                    // Insurance Premium Calculate
                    overallRiskPercent = (overallRisk - RISK_MIN) / riskRange;
                    insurancePremium = MIN_PREMIUM + (overallRiskPercent * premiumRange);
                    insurancePremiumLabel.setText("$" + Math.round(insurancePremium));
                    insurancePremiumMonthlyLabel.setText("$" + Math.round(insurancePremium / 12));
                    
                    // Overall projection of likeliness of one or more claims calculate
                    overallLikeliness = (GenderRiskCalculate(GenderDropDown.getValue())[1] + DateOfBirthRiskCalculate(DateOfBirthPicker.getValue().getYear())[1]
                            + MaritalStatusRiskCalculate(MaritalStatusDropDown.getValue())[1] + VehicleTypeRiskCalculate(VehicleTypeDropDown.getValue())[1]
                            + EngineHPRiskCalculate(Integer.parseInt(HorsepowerField.getText()))[1] + CreditScoreRiskCalculate(Integer.parseInt(CreditScoreField.getText()))[1]
                            + AnnualMilesDrivenRiskCalculate(Integer.parseInt(AnnualMilesDrivenField.getText()))[1]
                            + StateRiskCalculate(StateDropDown.getValue())[1])/8;
                    likelinessOfClaimsLabel.setText(df2.format(overallLikeliness * 100) + "%");
                    
                    // Overall projection of average number of claims annually calculate
                    overallNumberOfClaims = (GenderRiskCalculate(GenderDropDown.getValue())[2] + DateOfBirthRiskCalculate(DateOfBirthPicker.getValue().getYear())[2]
                            + MaritalStatusRiskCalculate(MaritalStatusDropDown.getValue())[2] + VehicleTypeRiskCalculate(VehicleTypeDropDown.getValue())[2]
                            + EngineHPRiskCalculate(Integer.parseInt(HorsepowerField.getText()))[2] + CreditScoreRiskCalculate(Integer.parseInt(CreditScoreField.getText()))[2]
                            + AnnualMilesDrivenRiskCalculate(Integer.parseInt(AnnualMilesDrivenField.getText()))[2]
                            + StateRiskCalculate(StateDropDown.getValue())[2])/8;
                    annualClaimsLabel.setText(df2.format(overallNumberOfClaims));
                    
                    // set arrow and text visible
                    arrow.setVisible(true);
                    arrowText.setVisible(true);
            }
        }
        catch(Exception e) {
            Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
            alert3.setTitle("Error");
            alert3.setHeaderText("Input must be an integer.");
            alert3.showAndWait();
        }   
        
        
    }

    
    private double[] GenderRiskCalculate(String selectedGender) {
        String gender = "none";
        
        double riskFactor = 0;
        
        double selectedItemCount = 0;
        double selectedItemLikelinessCount = 0;
        double selectedItemLikeliness = 0;
        
        double NOTSelectedItemCount = 0;
        double NOTSelectedItemLikelinessCount = 0;
        double NOTSelectedItemLikeliness = 0;
        
        double selectedItemNumberOfClaims = 0;
        double averageNumberOfClaims = 0;

        if (selectedGender.equals("Female")){
            gender = "F";
        }
        if (selectedGender.equals("Male")){
            gender = "M";
        }
                
        for (int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getGender().equals(gender)){
                selectedItemCount++;
                selectedItemNumberOfClaims += customerArchiveList.get(i).getAnnualClaims();
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    selectedItemLikelinessCount++;
                }
            }
            else {
                NOTSelectedItemCount++;
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    NOTSelectedItemLikelinessCount++;
                }
            }
        }       
        // calculate risk factor
        selectedItemLikeliness = selectedItemLikelinessCount/selectedItemCount;
        NOTSelectedItemLikeliness = NOTSelectedItemLikelinessCount/NOTSelectedItemCount;
        riskFactor = selectedItemLikeliness / NOTSelectedItemLikeliness;
                    
        averageNumberOfClaims = selectedItemNumberOfClaims / selectedItemCount;
        
        double[] result = {riskFactor, selectedItemLikeliness, averageNumberOfClaims};
        return result;
        
    }
    
    
    private double[] DateOfBirthRiskCalculate(int selectedYear) {
        String ageBucket = "none";
        int calculatedAge = 0;
        
        double riskFactor = 0;
        
        double selectedItemCount = 0;
        double selectedItemLikelinessCount = 0;
        double selectedItemLikeliness = 0;
        
        double NOTSelectedItemCount = 0;
        double NOTSelectedItemLikelinessCount = 0;
        double NOTSelectedItemLikeliness = 0;
        
        double selectedItemNumberOfClaims = 0;
        double averageNumberOfClaims = 0;

        calculatedAge = Year.now().getValue() - selectedYear;
        
        if (calculatedAge < 18){
            ageBucket = "<18";
        }
        else if (calculatedAge < 28){
            ageBucket = "18-27";
        }
        else if (calculatedAge < 35){
            ageBucket = "28-34";
        }
        else if (calculatedAge < 41){
            ageBucket = "35-40";
        }
        else if (calculatedAge >= 41){
            ageBucket = ">40";
        }
        else{
            ageBucket = "no age";
        }        
       
        for (int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getAgeBucket().equals(ageBucket)){
                selectedItemCount++;
                selectedItemNumberOfClaims += customerArchiveList.get(i).getAnnualClaims();
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    selectedItemLikelinessCount++;
                }
            }
            else {
                NOTSelectedItemCount++;
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    NOTSelectedItemLikelinessCount++;
                }
            }
        }       
        selectedItemLikeliness = selectedItemLikelinessCount/selectedItemCount;
        NOTSelectedItemLikeliness = NOTSelectedItemLikelinessCount/NOTSelectedItemCount;
        riskFactor = selectedItemLikeliness / NOTSelectedItemLikeliness;
        
        averageNumberOfClaims = selectedItemNumberOfClaims / selectedItemCount;
        
        double[] result = {riskFactor, selectedItemLikeliness, averageNumberOfClaims};
        return result;
        
    }
    
    private double[] MaritalStatusRiskCalculate(String selectedMaritalStatus) {
        
        double riskFactor = 0;
        
        double selectedItemCount = 0;
        double selectedItemLikelinessCount = 0;
        double selectedItemLikeliness = 0;
        
        double NOTSelectedItemCount = 0;
        double NOTSelectedItemLikelinessCount = 0;
        double NOTSelectedItemLikeliness = 0;

        double selectedItemNumberOfClaims = 0;
        double averageNumberOfClaims = 0;
       
        for (int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getMaritalStatus().equals(selectedMaritalStatus)){
                selectedItemCount++;
                selectedItemNumberOfClaims += customerArchiveList.get(i).getAnnualClaims();
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    selectedItemLikelinessCount++;
                }
            }
            else {
                NOTSelectedItemCount++;
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    NOTSelectedItemLikelinessCount++;
                }
            }
        }       
        selectedItemLikeliness = selectedItemLikelinessCount/selectedItemCount;
        NOTSelectedItemLikeliness = NOTSelectedItemLikelinessCount/NOTSelectedItemCount;
        riskFactor = selectedItemLikeliness / NOTSelectedItemLikeliness;
 
        averageNumberOfClaims = selectedItemNumberOfClaims / selectedItemCount;
        
        double[] result = {riskFactor, selectedItemLikeliness, averageNumberOfClaims};
        return result;
    }
    
    private double[] VehicleTypeRiskCalculate(String selectedVehicleType) {
        
        double riskFactor = 0;
        
        double selectedItemCount = 0;
        double selectedItemLikelinessCount = 0;
        double selectedItemLikeliness = 0;
        
        double NOTSelectedItemCount = 0;
        double NOTSelectedItemLikelinessCount = 0;
        double NOTSelectedItemLikeliness = 0;

        double selectedItemNumberOfClaims = 0;
        double averageNumberOfClaims = 0;
       
        for (int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getVehicleType().equals(selectedVehicleType)){
                selectedItemCount++;
                selectedItemNumberOfClaims += customerArchiveList.get(i).getAnnualClaims();
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    selectedItemLikelinessCount++;
                }
            }
            else {
                NOTSelectedItemCount++;
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    NOTSelectedItemLikelinessCount++;
                }
            }
        }       
        selectedItemLikeliness = selectedItemLikelinessCount/selectedItemCount;
        NOTSelectedItemLikeliness = NOTSelectedItemLikelinessCount/NOTSelectedItemCount;
        riskFactor = selectedItemLikeliness / NOTSelectedItemLikeliness;

        averageNumberOfClaims = selectedItemNumberOfClaims / selectedItemCount;
        
        double[] result = {riskFactor, selectedItemLikeliness, averageNumberOfClaims};
        return result;
    }
    
    private double[] EngineHPRiskCalculate(int selectedEngineHP) {
        String engineHPBucket = "none";        
        double riskFactor = 0;
        
        double selectedItemCount = 0;
        double selectedItemLikelinessCount = 0;
        double selectedItemLikeliness = 0;
        
        double NOTSelectedItemCount = 0;
        double NOTSelectedItemLikelinessCount = 0;
        double NOTSelectedItemLikeliness = 0;
        
        double selectedItemNumberOfClaims = 0;
        double averageNumberOfClaims = 0;
        
        if (selectedEngineHP < 90){
            engineHPBucket = "<90";
        }
        else if (selectedEngineHP < 160){
            engineHPBucket = "90-160";
        }
        else if (selectedEngineHP < 350){
            engineHPBucket = "161-350";
        }
        else if (selectedEngineHP >= 350){
            engineHPBucket = ">350";
        }
        else{
            engineHPBucket = "no HP";
        }        
       
        for (int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getEngineHPBucket().equals(engineHPBucket)){
                selectedItemCount++;
                selectedItemNumberOfClaims += customerArchiveList.get(i).getAnnualClaims();
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    selectedItemLikelinessCount++;
                }
            }
            else {
                NOTSelectedItemCount++;
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    NOTSelectedItemLikelinessCount++;
                }
            }
        }       
        selectedItemLikeliness = selectedItemLikelinessCount/selectedItemCount;
        NOTSelectedItemLikeliness = NOTSelectedItemLikelinessCount/NOTSelectedItemCount;
        riskFactor = selectedItemLikeliness / NOTSelectedItemLikeliness;
        
        averageNumberOfClaims = selectedItemNumberOfClaims / selectedItemCount;
        
        double[] result = {riskFactor, selectedItemLikeliness, averageNumberOfClaims};
        return result;
        
    }
    
    private double[] CreditScoreRiskCalculate(int selectedCreditScore) {
        String creditScore = "none";        
        double riskFactor = 0;
        
        double selectedItemCount = 0;
        double selectedItemLikelinessCount = 0;
        double selectedItemLikeliness = 0;
        
        double NOTSelectedItemCount = 0;
        double NOTSelectedItemLikelinessCount = 0;
        double NOTSelectedItemLikeliness = 0;
        
        double selectedItemNumberOfClaims = 0;
        double averageNumberOfClaims = 0;
        
        if ((selectedCreditScore >= 300) && (selectedCreditScore <= 579)){
            creditScore = "Very Poor";
        }
        else if ((selectedCreditScore >= 580) && (selectedCreditScore <= 669)){
            creditScore = "Fair";
        }
        else if ((selectedCreditScore >= 670) && (selectedCreditScore <= 739)){
            creditScore = "Good";
        }
        else if ((selectedCreditScore >= 740) && (selectedCreditScore <= 799)){
            creditScore = "Very Good";
        }
        else if ((selectedCreditScore >= 800) && (selectedCreditScore <= 850)){
            creditScore = "Exceptional";
        }
        else {
            creditScore = "no credit";
        }        
       
        for (int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getCreditHistory().equals(creditScore)){
                selectedItemCount++;
                selectedItemNumberOfClaims += customerArchiveList.get(i).getAnnualClaims();
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    selectedItemLikelinessCount++;
                }
            }
            else {
                NOTSelectedItemCount++;
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    NOTSelectedItemLikelinessCount++;
                }
            }
        }       
        selectedItemLikeliness = selectedItemLikelinessCount/selectedItemCount;
        NOTSelectedItemLikeliness = NOTSelectedItemLikelinessCount/NOTSelectedItemCount;
        riskFactor = selectedItemLikeliness / NOTSelectedItemLikeliness;
        
        averageNumberOfClaims = selectedItemNumberOfClaims / selectedItemCount;
        
        double[] result = {riskFactor, selectedItemLikeliness, averageNumberOfClaims};
        return result;
        
    }
    
    private double[] AnnualMilesDrivenRiskCalculate(int selectedAnnualMilesDriven) {
        String annualMilesDrivenBucket = "none";        
        double riskFactor = 0;
        
        double selectedItemCount = 0;
        double selectedItemLikelinessCount = 0;
        double selectedItemLikeliness = 0;
        
        double NOTSelectedItemCount = 0;
        double NOTSelectedItemLikelinessCount = 0;
        double NOTSelectedItemLikeliness = 0;
        
        double selectedItemNumberOfClaims = 0;
        double averageNumberOfClaims = 0;
        
        if (selectedAnnualMilesDriven < 15000){
            annualMilesDrivenBucket = "<15k";
        }
        else if (selectedAnnualMilesDriven <= 25000){
            annualMilesDrivenBucket = "15k-25k";
        }
        else if (selectedAnnualMilesDriven > 25000){
            annualMilesDrivenBucket = ">25k";
        }
        else{
            annualMilesDrivenBucket = "no annual miles";
        }        
       
        for (int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getMilesDrivenBucket().equals(annualMilesDrivenBucket)){
                selectedItemCount++;
                selectedItemNumberOfClaims += customerArchiveList.get(i).getAnnualClaims();
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    selectedItemLikelinessCount++;
                }
            }
            else {
                NOTSelectedItemCount++;
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    NOTSelectedItemLikelinessCount++;
                }
            }
        }       
        selectedItemLikeliness = selectedItemLikelinessCount/selectedItemCount;
        NOTSelectedItemLikeliness = NOTSelectedItemLikelinessCount/NOTSelectedItemCount;
        riskFactor = selectedItemLikeliness / NOTSelectedItemLikeliness;
        
        averageNumberOfClaims = selectedItemNumberOfClaims / selectedItemCount;
        
        double[] result = {riskFactor, selectedItemLikeliness, averageNumberOfClaims};
        return result;
        
    }
    
    private double[] StateRiskCalculate(String selectedState) {
        
        double riskFactor = 0;
        
        double selectedItemCount = 0;
        double selectedItemLikelinessCount = 0;
        double selectedItemLikeliness = 0;
        
        double NOTSelectedItemCount = 0;
        double NOTSelectedItemLikelinessCount = 0;
        double NOTSelectedItemLikeliness = 0;

        double selectedItemNumberOfClaims = 0;
        double averageNumberOfClaims = 0;
       
        for (int i = 0; i < customerArchiveList.size(); ++i){
            if (customerArchiveList.get(i).getState().equals(selectedState)){
                selectedItemCount++;
                selectedItemNumberOfClaims += customerArchiveList.get(i).getAnnualClaims();
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    selectedItemLikelinessCount++;
                }
            }
            else {
                NOTSelectedItemCount++;
                if (customerArchiveList.get(i).getAnnualClaims() >= 1){
                    NOTSelectedItemLikelinessCount++;
                }
            }
        }       
        selectedItemLikeliness = selectedItemLikelinessCount/selectedItemCount;
        NOTSelectedItemLikeliness = NOTSelectedItemLikelinessCount/NOTSelectedItemCount;
        riskFactor = selectedItemLikeliness / NOTSelectedItemLikeliness;
 
        averageNumberOfClaims = selectedItemNumberOfClaims / selectedItemCount;
        
        double[] result = {riskFactor, selectedItemLikeliness, averageNumberOfClaims};
        return result;
    }
}


