package com.prescription.dto.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * DTO class for UserInput
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInput {

    private List<String> sources;
    private String rxcui;

    public UserInput() {
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public String getRxcui() {
        return rxcui;
    }

    public void setRxcui(String rxcui) {
        this.rxcui = rxcui;
    }
}
