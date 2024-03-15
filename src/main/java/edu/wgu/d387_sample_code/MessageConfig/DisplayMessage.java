package edu.wgu.d387_sample_code.MessageConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class DisplayMessage {
   // private Locale locale;
    private ResourceBundle resourceBundle;

    public DisplayMessage(){}
    public DisplayMessage(String language, String country){
       Locale locale = new Locale(language, country);
       this.resourceBundle = ResourceBundle.getBundle("welcomeMessage", locale);
    }

    public String getWelcomeMessage(){
        if (this.resourceBundle != null){
            return resourceBundle.getString("welcomeMessage");
        }
        else{
         return "error: RB is not intialized!";
       }

    }

    //test
//    public void testWelcomeMessage(){
//        String welcomeMessage = getWelcomeMessage();
//        System.out.println("test test test "+ welcomeMessage);
//    }
//    public static void main(String[] args) {
//        DisplayMessage displayMessage = new DisplayMessage("en", "US");
//        displayMessage.testWelcomeMessage();
//    }

}





