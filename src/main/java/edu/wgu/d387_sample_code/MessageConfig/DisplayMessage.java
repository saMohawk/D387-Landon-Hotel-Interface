package edu.wgu.d387_sample_code.MessageConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class DisplayMessage {
    private Locale locale;
    private ResourceBundle resourceBundle;

    public String getWelcomeMessage(){
    return resourceBundle.getString("welcomeMessage");
}

    public DisplayMessage(){

    }
    public DisplayMessage(String language, String country){
        locale = new Locale(language, country);
        resourceBundle = ResourceBundle.getBundle("welcomeMessage", locale);
    }
    //test
//    public void testWelcomeMessage(){
//        String welcomeMessage = getWelcomeMessage();
//        System.out.println("test test test "+ welcomeMessage);
//    }
//    public static void main(String[] args) {
//        DisplayMessage displayMessage = new DisplayMessage("fr", "CA");
//        displayMessage.testWelcomeMessage();
//    }

}





