package com.prescription.dto.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prescription.dto.consume.InteractionTypeElement;

import java.util.List;

/**
 * DTO class for InteractionTypeGroup
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractionTypeGroupElement {

    private String sourceDisclaimer;
    private String sourceName;
    private List<InteractionTypeElement> interactionType;

    public InteractionTypeGroupElement() {
    }

    public String getSourceDisclaimer() {
        return sourceDisclaimer;
    }

    public void setSourceDisclaimer(String sourceDisclaimer) {
        this.sourceDisclaimer = sourceDisclaimer;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public List<InteractionTypeElement> getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(List<InteractionTypeElement> interactionType) {
        this.interactionType = interactionType;
    }
}
