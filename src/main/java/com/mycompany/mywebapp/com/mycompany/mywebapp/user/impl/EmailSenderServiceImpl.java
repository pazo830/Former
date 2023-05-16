package com.mycompany.mywebapp.com.mycompany.mywebapp.user.impl;

import com.mycompany.mywebapp.com.mycompany.mywebapp.user.EmailSenderService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void SendEmail(String to, String Subject, String Message) {
     SimpleMailMessage simplemailmessage = new SimpleMailMessage();
      simplemailmessage.setFrom("zainabseryu@gmail.com");
      simplemailmessage.setTo(to);
      simplemailmessage.setSubject(Subject);
      simplemailmessage.setText(Message);
       this.mailSender.send(simplemailmessage);

    }
}
