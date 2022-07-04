package com.example.firma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/wyslij")
    public String sendMail(@RequestParam String CC, @RequestParam String subject, @RequestParam String text) {
        text = text + "\n" + CC;
        mailController.sendMessage(CC, subject, text);
        return "redirect:/contact";
    }
}
