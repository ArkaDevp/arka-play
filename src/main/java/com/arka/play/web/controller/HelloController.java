package com.arka.play.web.controller;

import com.arka.play.domain.service.ArkaPlayAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String platform;

    private final ArkaPlayAIService arkaPlayAIService;

    public HelloController(@Value("${spring.application.name}")String platform, ArkaPlayAIService arkaPlayAIService) {
        this.platform = platform;
        this.arkaPlayAIService = arkaPlayAIService;
    }

    @RequestMapping("/hello")
    public String helloWorld(){
        return this.arkaPlayAIService.generateGreeting(platform);
    }
}
