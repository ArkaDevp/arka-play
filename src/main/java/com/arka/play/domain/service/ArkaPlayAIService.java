package com.arka.play.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface ArkaPlayAIService {

    @UserMessage("""
            Generate a welcome greeting to the platform of management of Movies {{platform}}.
            Use less than 120 characters and make it with style.
            """)
    String generateGreeting(@V("platform") String platform);
}
