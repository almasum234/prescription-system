package com.prescription.dto.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO class for MinConceptItem
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MinConceptItem {
    private String rxcui;
    private String name;
    private String tty;

    public MinConceptItem() {
    }

    public String getRxcui() {
        return rxcui;
    }

    public void setRxcui(String rxcui) {
        this.rxcui = rxcui;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTty() {
        return tty;
    }

    public void setTty(String tty) {
        this.tty = tty;
    }
}
