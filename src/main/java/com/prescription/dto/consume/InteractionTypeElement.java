package com.prescription.dto.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * DTO class for InteractionType
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractionTypeElement {

    private String comment;
    private MinConceptItem minConceptItem;
    private List<InteractionPairElement> interactionPair;

    public InteractionTypeElement() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MinConceptItem getMinConceptItem() {
        return minConceptItem;
    }

    public void setMinConceptItem(MinConceptItem minConceptItem) {
        this.minConceptItem = minConceptItem;
    }

    public List<InteractionPairElement> getInteractionPair() {
        return interactionPair;
    }

    public void setInteractionPair(List<InteractionPairElement> interactionPair) {
        this.interactionPair = interactionPair;
    }
}
