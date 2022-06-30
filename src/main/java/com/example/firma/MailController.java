package com.example.firma;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailController {

    private JavaMailSender mailSender;

    public MailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessageWithAttachment(String cc, String subject, String text) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("test@javny.pl");
            helper.setTo("marcin90w@gmail.com");
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(text);
            mailSender.send(message);
        } catch (RuntimeException | MessagingException e) {
            e.getMessage();
        }
    }
}