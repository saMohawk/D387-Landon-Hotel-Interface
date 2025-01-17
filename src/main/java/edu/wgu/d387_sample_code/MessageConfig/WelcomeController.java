package edu.wgu.d387_sample_code.MessageConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin
public class WelcomeController {

    private DisplayMessage displayMessage;

    private Executor thr = Executors.newFixedThreadPool(2);

   //@Autowired
    public WelcomeController(DisplayMessage displayMessage) {
        this.displayMessage = displayMessage;
    }

    @GetMapping("/welcome")
    public ResponseEntity<List<String>> getWelcomeMessage(){
        List<String> w = new ArrayList<String>();

        thr.execute(() ->{
            DisplayMessage threadEn = new DisplayMessage("en", "US");
            w.add(threadEn.getWelcomeMessage());
            System.out.println(threadEn.getWelcomeMessage());
        });

        thr.execute(() ->{
            DisplayMessage threadFr = new DisplayMessage("fr", "CA");
            w.add(threadFr.getWelcomeMessage());
            System.out.println(threadFr.getWelcomeMessage());
        });

        return ResponseEntity.ok(w);

    }

}

//malcom suggested creating and starting the threads here







