package com.company;

public class Registration {
    private String username;
    private int contact;
    private String password;
    private String conPassword;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getContact() {
        return contact;
    }
    public void setContact(int contact) {
        this.contact = contact;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return conPassword;
    }
    public void setConfirmPassword(String confrimPassword) {
        this.conPassword = confrimPassword;
    }
}
