package org.startrek.startrek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CommsController {

    @Value("${captain.url}")
    private String captainUrl;
    @Value("${science-officer.url}")
    private String scienceOfficerUrl;
    @Value("${bridge.url}")
    private String bridgeUrl;

    @Value("${spring.application.name}")
    private String appName;

    private String replyString = "yes %1$s, %2$s here";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("app-name")
    public String getAppName(){
        return appName;
    }

    @PostMapping
    public String respond(String caller){
        return String.format(replyString,caller,appName);
    }

    @GetMapping(value = "bridge")
    public String callBridge(){

        //TODO: perform post to bridge and return response

        return String.format(replyString,appName,"bridge");
    }

    @GetMapping(value = "captain")
    public String callCaptain(){

        //TODO: perform post to captain and return response

        return String.format(replyString,appName,"captain");
    }

    @GetMapping(value = "science-officer")
    public String callScienceOfficer(){

        //TODO: perform post to science officer and return response

        return String.format(replyString,appName,"science officer");
    }


}
