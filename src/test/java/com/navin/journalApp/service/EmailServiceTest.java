package com.navin.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendMail(){
        emailService.sendEmail("navinpatilwork@gmail.com","Testing Java SMTP mail sender", "Hello buddy");
    }
}
