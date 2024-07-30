package com.example.sam;

public class NotificationItem {

    private String message;
    private String action;

    public NotificationItem(String message, String action) {
        this.message = message;
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public String getAction() {
        return action;
    }
}
