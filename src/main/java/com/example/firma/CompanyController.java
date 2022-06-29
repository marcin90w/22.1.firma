package com.example.firma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CompanyController {

    MailController mailController;

    public CompanyController(MailController mailController) {
        this.mailController = mailController;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/regulamin")
    public String terms() {
        return "terms";
    }

    @GetMapping("/kontakt")
    public String prepareMessage() {
        return "contact";
    }

    @ResponseBody
    @GetMapping("wyslij")
    public String sendMail(@RequestParam String from, @RequestParam String subject, @RequestParam String text) {
        text = text + "/n" + from;
        mailController.sendMessageWithAttachment("marcin90w@gmail.com", subject, text);

        return "contact";
    }
}
