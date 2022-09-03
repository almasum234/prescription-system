package com.prescription.dto.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * DTO class for ResponseApiResult
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseApiResult {

    private String nlmDisclaimer;
    private UserInput userInput;
    private List<InteractionTypeGroupElement> interactionTypeGroup;

    public ResponseApiResult() {
    }

    public String getNlmDisclaimer() {
        return nlmDisclaimer;
    }

    public void setNlmDisclaimer(String nlmDisclaimer) {
        this.nlmDisclaimer = nlmDisclaimer;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

    public List<InteractionTypeGroupElement> getInteractionTypeGroup() {
        return interactionTypeGroup;
    }

    public void setInteractionTypeGroup(List<InteractionTypeGroupElement> interactionTypeGroup) {
        this.interactionTypeGroup = interactionTypeGroup;
    }
}
