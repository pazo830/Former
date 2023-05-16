package com.mycompany.mywebapp.com.mycompany.mywebapp.user.impl;

import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderServiceImplBuilder {
    private JavaMailSender mailSender;

    public EmailSenderServiceImplBuilder setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
        return this;
    }

    public EmailSenderServiceImpl createEmailSenderServiceImpl() {
        return new EmailSenderServiceImpl(mailSender);
    }
}