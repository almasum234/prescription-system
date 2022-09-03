package com.prescription.dto.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO class for InteractionConcept
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractionConceptElement {

    private SourceConceptItem sourceConceptItem;
    private MinConceptItem minConceptItem;

    public InteractionConceptElement() {
    }

    public SourceConceptItem getSourceConceptItem() {
        return sourceConceptItem;
    }

    public void setSourceConceptItem(SourceConceptItem sourceConceptItem) {
        this.sourceConceptItem = sourceConceptItem;
    }

    public MinConceptItem getMinConceptItem() {
        return minConceptItem;
    }

    public void setMinConceptItem(MinConceptItem minConceptItem) {
        this.minConceptItem = minConceptItem;
    }
}
