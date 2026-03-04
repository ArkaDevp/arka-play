package com.arka.play.domain.service;

import dev.langchain4j.service.SystemMessage;
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

    @SystemMessage("""
            Your are an expert in cine that recommend personalized movies according to the user preferences.
            You must recommend maximum 3 movies.
            Don't include movies that are outside of Arka-Play  
            """)
    String generateMoviesSuggestion(@UserMessage String userMessage);
}
