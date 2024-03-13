package edu.wgu.d387_sample_code.MessageConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.String;

import java.util.Locale;

@RestController
@CrossOrigin
public class WelcomeController {

    private DisplayMessage displayMessage;

   //@Autowired
    public WelcomeController(DisplayMessage displayMessage) {
        this.displayMessage = displayMessage;
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage(){
        String welcomeMessage =  displayMessage.getWelcomeMessage();

        Thread threadEn = new Thread(()-> {
            DisplayMessage welcomeMessageEn = new DisplayMessage("en", "US");
            System.out.println(welcomeMessageEn.getWelcomeMessage());
        });

        Thread threadFr = new Thread(()-> {
            DisplayMessage welcomeMessageFr = new DisplayMessage("fr", "CA");
            System.out.println(welcomeMessageFr.getWelcomeMessage());
        });

        threadFr.start();
        threadEn.start();

        return welcomeMessage; //is this what I am to be returning?

    }

}

//malcom suggested creating and starting the threads here
//create a get mapping request in UI->src-> app.component.ts






