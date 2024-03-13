package edu.wgu.d387_sample_code.MessageConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ThreadManagement {

   private final MessageSource messageSource;

   @Autowired
   public ThreadManagement(MessageSource messageSource){
       this.messageSource = messageSource;
   }


    public void displayWelcomeMessages() {

       String welcomeMessageEn = messageSource.getMessage("welcomeMessage.en", null, Locale.ENGLISH);
       String welcomeMessageFr = messageSource.getMessage("welcomeMessage.fr", null, Locale.FRENCH);

       //test messages are parsed correctly
       System.out.println("test En: " +welcomeMessageEn);
       System.out.println("test fr: "+ welcomeMessageFr);

        Thread threadEn = new Thread(() -> System.out.println(welcomeMessageEn));
        Thread threadFr = new Thread(() -> System.out.println(welcomeMessageFr));

        threadEn.start();
        threadFr.start();
    }



}

