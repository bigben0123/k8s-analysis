package com.sa.web;

import com.sa.web.dto.SentenceDto;
import com.sa.web.dto.SentimentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
public class SentimentController {

    @Value("${sa.logic.api.url}")
    private String saLogicApiUrl;

    @PostMapping("/sentiment")
    public SentimentDto sentimentAnalysis(@RequestBody SentenceDto sentenceDto) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForEntity(saLogicApiUrl + "/analyse/sentiment",
                sentenceDto, SentimentDto.class)
                .getBody();
        
       
    }


    @PostMapping("/analyse")
    public SentenceDto analyse(@RequestBody SentenceDto a) {
        RestTemplate restTemplate = new RestTemplate();
        a.setSentence("报告，已经分析完毕！I've got it");
        return a;
     
    }

    
    @GetMapping("/testHealth")
    public void testHealth() {
    }
    

    @GetMapping("/")
    public SentimentDto demo() {
    	 SentimentDto a = new SentimentDto();
         a.setSentence("I've got it");
         a.setPolarity(1);
         return a;
    }

}


