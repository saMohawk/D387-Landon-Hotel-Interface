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


//    @GetMapping("/presentation")
//    public String getPresentationTime(){
//


//        //create specific time
//        LocalDateTime presentationTime = LocalDateTime.of(2024, 4, 18, 10, 30);
//        String presentationTimeString = presentationTime.format(DateTimeFormatter.ofPattern("HH:mm"));
//
//        //UTC
//        String UTCtime = presentationTime.atZone(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("HH:mm"));
//
//        //MST
//        String MSTtime = presentationTime.atZone(ZoneId.of("America/Denver")).format(DateTimeFormatter.ofPattern("HH:mm"));
//
//        //EST
//        String ESTtime = presentationTime.atZone(ZoneId.of("America/New_York")).format(DateTimeFormatter.ofPattern("HH:mm"));
//
//
//        return "UTC: " +UTCtime + " MST: " + MSTtime + " EST: "+ ESTtime;


}

