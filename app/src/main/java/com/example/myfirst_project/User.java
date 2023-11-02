package com.example.myfirst_project;

public class User {
    private String uname; // Matches the key "uname" in Firebase
    private String uimage; // Matches the key "uimage" in Firebase

    public User() {
        // Default constructor required for Firebase
    }

    public User(String uname, String uimage) {
        this.uname = uname;
        this.uimage = uimage;
    }

    public String getUname() {
        return uname;
    }

    public String getUimage() {
        return uimage;
    }
}
