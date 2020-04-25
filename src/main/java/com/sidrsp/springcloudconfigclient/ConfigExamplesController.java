package com.sidrsp.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigExamplesController {

    @Autowired
    private DbSettings dbSettings;

    @Value("${greeting.message: default Hi}")
    private String greetingMsg;

    @Value("${app.name}")
    private String appName;

    @Value("${app.desc}")
    private String appDesc;


    @RequestMapping("/sayhello")
    public String greeting() {
        return appName + appDesc + greetingMsg;
    }

    @RequestMapping("/withConfigProperties")
    public String withConfigProperties() {
        return greetingMsg + dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort();
    }

}
