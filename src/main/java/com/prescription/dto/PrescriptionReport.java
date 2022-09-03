package com.prescription.dto;


import java.util.Date;

/**
 * DTO class for LoginUserDetails
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
public class PrescriptionReport {

    private Date prescriptionDate;
    private Long count;

    public PrescriptionReport(Date prescriptionDate, Long count) {
        this.prescriptionDate = prescriptionDate;
        this.count = count;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
