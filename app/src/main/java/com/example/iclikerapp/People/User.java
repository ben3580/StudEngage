package com.example.iclikerapp.People;

import java.util.regex.Pattern;
import com.example.iclikerapp.Server.Classroom;

public abstract class User {


    protected String name;
    protected String username;
    protected String password;
    protected String email;
    protected Classroom joinedClassroom;

    public User(String username, String password) {
        createAccount(username, password);
        this.email = null;
        this.joinedClassroom = null;
    }

    public void createAccount(String username, String password){
        setUsername(username);
        setPassword(password);
    }
    
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // TODO: need to wait until classroom class is finished 
    public abstract void joinClassroom(Classroom classroom);

    public abstract void exitClassroom(Classroom classroom);

    public String getUsername(){
        return this.username;
    }

    private void setUsername(String username){
        this.username = username;
    } 

    public String getPassword(){
        return this.password;
    }

    private void setPassword(String password){
        if(validPassword(password)) this.password = password;
    }

    // return if the password fulfill the requirements
    private boolean validPassword(String password){
        Boolean validPassword = true;
        String outputString = "";
        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Pattern specialpPattern = Pattern.compile("\\W");

        if(password.length() < 8) {
            outputString = "Password needs to be at least 8 words";
            validPassword = false;
        }
        if(specialpPattern.matcher(password).find()){
            outputString = "Password should NOT contain special characters";
            validPassword = false;
        }
        if(!uppercasePattern.matcher(password).find()) {
            outputString = "The password required at least one lowercase Letter";
            validPassword = false;
        }
        if(!lowercasePattern.matcher(password).find()) {
            outputString = "The password required at least one CAPITAL LETTER";
            validPassword = false;
        }
        if(validPassword) {
            outputString = "Password set successfully";
        }

        // TODO: System.out.println() should be replaced by UI
        System.out.println(outputString);

        return validPassword;
    }
}
