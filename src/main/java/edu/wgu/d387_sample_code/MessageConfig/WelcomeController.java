package edu.wgu.d387_sample_code.MessageConfig;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class WelcomeController {

    private DisplayMessage displayMessage;

    public WelcomeController(DisplayMessage displayMessage){
        this.displayMessage = displayMessage;
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage(Locale locale){
        return displayMessage.getWelcomeMessage(locale);
    }
}

