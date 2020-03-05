package com.register;
import java.io.Serializable;
//Pojo init class
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    //variable declaration
    private String username;
    private String password;  
    //getters and setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
