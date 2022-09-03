package com.prescription.dto.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prescription.dto.consume.InteractionConceptElement;

import java.util.List;

/**
 * DTO class for InteractionPair
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractionPairElement {

    private List<InteractionConceptElement> interactionConcept;
    private String severity;
    private String description;

    public InteractionPairElement() {
    }

    public List<InteractionConceptElement> getInteractionConcept() {
        return interactionConcept;
    }

    public void setInteractionConcept(List<InteractionConceptElement> interactionConcept) {
        this.interactionConcept = interactionConcept;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
