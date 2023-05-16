package com.mycompany.mywebapp.com.mycompany.mywebapp.user.Controller;

import com.mycompany.mywebapp.com.mycompany.mywebapp.user.EmailSenderService;


import com.mycompany.mywebapp.com.mycompany.mywebapp.user.resource.EmailMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
private final EmailSenderService emailsenderservice;

    public EmailController(EmailSenderService emailsenderservice) {
        this.emailsenderservice = emailsenderservice;
    }

    @PostMapping("/send-email")
public ResponseEntity  sendEmail(@RequestBody EmailMessage emailMessage) {
  this.emailsenderservice.SendEmail(emailMessage.getTo() , emailMessage.getSubject() , emailMessage.getMessage());
  return ResponseEntity.ok("Success");
}


}
