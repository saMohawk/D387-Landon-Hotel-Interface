package edu.wgu.d387_sample_code.MessageConfig;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TimeController {

    @GetMapping("/presentation")
    public List<String> getPresentationTime() {
        List<String> presentationTime = new ArrayList<>();

        // Add the presentation times for UTC, MT, and EST
        presentationTime.add(getFormattedTime("UTC"));
        presentationTime.add(getFormattedTime("America/Denver")); // Mountain Time (MT)
        presentationTime.add(getFormattedTime("America/New_York")); // Eastern Standard Time (EST)

        return presentationTime;
    }

    private String getFormattedTime(String zoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(zoneId));
        return zonedDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }



//

}

