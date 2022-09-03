package com.prescription.form;

import com.prescription.model.Prescription;

import java.util.List;

/**
 * PrescriptionSearchForm class
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
public class PrescriptionSearchForm {

    private String searchDtSt;

    private String searchDtTo;

    private List<Prescription> prescriptionList;

    public String getSearchDtSt() {
        return searchDtSt;
    }

    public void setSearchDtSt(String searchDtSt) {
        this.searchDtSt = searchDtSt;
    }

    public String getSearchDtTo() {
        return searchDtTo;
    }

    public void setSearchDtTo(String searchDtTo) {
        this.searchDtTo = searchDtTo;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
}
