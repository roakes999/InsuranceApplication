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
public class UserLoginInfo {
    String username;
    String password;
    
    public UserLoginInfo (String username, String password){
        setUsername(username);
        setPassword(password);
    }
    
    //setters
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    //getters
    
    public String getUsername(){
        return username; 
    }
    
    public String getPassword(){
        return password;
    }
}
