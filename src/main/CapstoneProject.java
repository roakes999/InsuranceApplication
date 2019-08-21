/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rob
 */
public class CapstoneProject extends Application {

    public static ArrayList<Customer> customerArchiveList = new ArrayList<>();
    
    private static void populateCustomerDataArchive() {
        int customerID;
        String gender;
        int engineHP;
        int creditScore;
        int yearsExperience;
        int annualClaims;
        String maritalStatus;
        String vehicleType;
        String milesDrivenBucket;
        int sizeOfFamily;
        String ageBucket; // uses > <
        String creditHistory; // Very Poor, Fair, Good, Very Good, Exceptional
        String state;
        String engineHPBucket;
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/InsuranceDataFile.csv"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CapstoneProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line;
        try {
            line = br.readLine(); // skips header
        } catch (IOException ex) {
            Logger.getLogger(CapstoneProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while ((line = br.readLine()) != null){
                String[] fields = line.split(",");
                customerID = parseInt(fields[0]);
                gender = fields[2];
                engineHP = parseInt(fields[3]);
                creditScore = parseInt(fields[4]);
                yearsExperience = parseInt(fields[5]);
                annualClaims = parseInt(fields[6]);
                maritalStatus = fields[7];
                vehicleType = fields[8];
                milesDrivenBucket = fields[14];
                sizeOfFamily = parseInt(fields[10]);
                ageBucket = fields[11];
                creditHistory = fields[15];
                state = fields[16];
                engineHPBucket = fields[12];
                customerArchiveList.add(new Customer(customerID, gender, engineHP, creditScore, yearsExperience, annualClaims, maritalStatus,
                        vehicleType, milesDrivenBucket, sizeOfFamily, ageBucket, creditHistory, state, engineHPBucket));
            }
        } catch (IOException ex) {
            Logger.getLogger(CapstoneProject.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(CapstoneProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Insurance Analyzer 2019");
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        populateCustomerDataArchive();
        launch(args);
        
    }
}
