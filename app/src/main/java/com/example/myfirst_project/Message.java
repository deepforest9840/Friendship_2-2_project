package com.example.myfirst_project;


public class Message {
    private String senderName;
    private String text;

    public Message() {
        // Default constructor required for Firebase
    }

    public Message(String senderName, String text) {
        this.senderName = senderName;
        this.text = text;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }
}
