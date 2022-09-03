package com.prescription.form;

import javax.validation.constraints.*;

/**
 * Prescription form class
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
public class PrescriptionForm {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Prescription date is mandatory")
    private String prescriptionDate;

    @NotBlank(message = "Patient name is mandatory")
    @Size(max = 200, message = "Patient name text length should not be more then 200 character(s)")
    private String patientName;

    @NotNull(message = "Please enter patient age year. ")
    @Max(value = 150, message = "Patient age year should be less then or equal 150")
    @Min(value = 0, message = "Patient age year should be grater then 0")
    private Integer patientAgeYear;

    @NotNull(message = "Please enter patient age month")
    @Max(value = 12, message = "Patient age month should be less then or equal 12")
    @Min(value = 0, message = "Patient age month should be grater then 0")
    private Integer patientAgeMonth;

    @NotNull(message = "Please select a gender")
    private Integer patientGender;

    @Size(max = 500, message = "Diagnosis text length should not be more then 500 character(s)")
    private String diagnosis;

    @Size(max = 500, message = "Medicines text length should not be more then 500 character(s)")
    private String medicines;

    private String nextVisitDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAgeYear() {
        return patientAgeYear;
    }

    public void setPatientAgeYear(Integer patientAgeYear) {
        this.patientAgeYear = patientAgeYear;
    }

    public Integer getPatientAgeMonth() {
        return patientAgeMonth;
    }

    public void setPatientAgeMonth(Integer patientAgeMonth) {
        this.patientAgeMonth = patientAgeMonth;
    }

    public Integer getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Integer patientGender) {
        this.patientGender = patientGender;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(String nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }
}