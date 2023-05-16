package com.mycompany.mywebapp.com.mycompany.mywebapp.user.resource;

public class EmailMessage {
  private  String to;
    private String Subject;
    private String Message;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public EmailMessage(String to, String subject, String message) {
        this.to = to;
        Subject = subject;
        Message = message;
    }

    public EmailMessage() {
    }
}
