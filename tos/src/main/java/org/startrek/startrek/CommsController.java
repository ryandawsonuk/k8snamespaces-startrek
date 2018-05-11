package org.startrek.startrek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CommsController {

    @Value("${captain.call.url}")
    private String captainUrl;
    @Value("${science-officer.call.url}")
    private String scienceOfficerUrl;
    @Value("${bridge.call.url}")
    private String bridgeUrl;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("app-name")
    public String getAppName(){
        return appName;
    }

    @PostMapping("call")
    public String respond(@RequestBody String caller){
        return String.format("yes %1$s, %2$s here",caller,appName);
    }

    @GetMapping(value = "bridge")
    public String callBridge(){
        return restTemplate.postForEntity(bridgeUrl, appName, String.class).getBody();
    }

    @GetMapping(value = "captain")
    public String callCaptain(){
        return restTemplate.postForEntity(captainUrl, appName, String.class).getBody();
    }

    @GetMapping(value = "science-officer")
    public String callScienceOfficer(){
        return restTemplate.postForEntity(scienceOfficerUrl, appName, String.class).getBody();
    }


}
