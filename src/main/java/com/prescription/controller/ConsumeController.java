package com.prescription.controller;

import com.prescription.dto.consume.ResponseApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Controller class for consume external api
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@Controller
@RequestMapping("/consume")
public class ConsumeController {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    /**
     * Show result by consuming external API data
     * @param model Model
     * @return String viewName
     */
    @GetMapping("/external")
    String getExternalApiData(Model model) {
        String restEndpoint = "https://rxnav.nlm.nih.gov/REST/interaction/interaction.json?rxcui=341248";
        ResponseApiResult responseApiData = restTemplate.getForObject(restEndpoint, ResponseApiResult.class);
        model.addAttribute("responseApiData", responseApiData);
        return "external-data";
    }

}
