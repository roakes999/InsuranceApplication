/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Rob
 */
public final class Customer {
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
    
    public Customer (int customerID, String gender, int engineHP, int creditScore, int yearsExperience, int annualClaims, String maritalStatus, 
            String vehicleType, String milesDrivenBucket, int sizeOfFamily, String ageBucket, String creditHistory, String state, String engineHPBucket){
    
        setCustomerID(customerID);
        setGender(gender);
        setEngineHP(engineHP);
        setCreditScore(creditScore);
        setYearsExperience(yearsExperience);
        setAnnualClaims(annualClaims);
        setMaritalStatus(maritalStatus);
        setVehicleType(vehicleType);
        setMilesDrivenBucket(milesDrivenBucket);
        setSizeOfFamily(sizeOfFamily);
        setAgeBucket(ageBucket);
        setCreditHistory(creditHistory);
        setState(state);
        setEngineHPBucket(engineHPBucket);
    }
    
    // Setters
    
    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public void setEngineHP(int engineHP){
        this.engineHP = engineHP;
    }
        
    public void setCreditScore(int creditScore){
        this.creditScore = creditScore;
    }
    
    public void setYearsExperience(int yearsExperience){
        this.yearsExperience = yearsExperience;
    }
    
    public void setAnnualClaims(int annualClaims){
        this.annualClaims = annualClaims;  
    }
    
    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }
    
    public void setVehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }
    
    public void setMilesDrivenBucket(String milesDrivenBucket){
        this.milesDrivenBucket = milesDrivenBucket;
    }
    
    public void setSizeOfFamily(int sizeOfFamily){
        this.sizeOfFamily = sizeOfFamily;
    }
    
    public void setAgeBucket(String ageBucket){
        this.ageBucket = ageBucket;
    }
    
    public void setCreditHistory(String creditHistory){
        this.creditHistory = creditHistory;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public void setEngineHPBucket(String engineHPBucket){
        this.engineHPBucket = engineHPBucket;
    }
        
    // Getters
    
    public int getCustomerID(){
        return customerID;
    }
    
    public String getGender(){
        return gender;
    }
    
    public int getEngineHP(){
        return engineHP;
    }
        
    public int getCreditScore(){
        return creditScore;
    }
    
    public int getYearsExperience(){
        return yearsExperience;
    }
    
    public int getAnnualClaims(){
        return annualClaims;  
    }
    
    public String getMaritalStatus(){
        return maritalStatus;
    }
    
    public String getVehicleType(){
        return vehicleType;
    }
    
    public String getMilesDrivenBucket(){
        return milesDrivenBucket;
    }
    
    public int getSizeOfFamily(){
        return sizeOfFamily;
    }
    
    public String getAgeBucket(){
        return ageBucket;
    }
    
    public String getCreditHistory(){
        return creditHistory;
    }
    
    public String getState(){
        return state;
    }
    
    public String getEngineHPBucket(){
        return engineHPBucket;
    }
}
