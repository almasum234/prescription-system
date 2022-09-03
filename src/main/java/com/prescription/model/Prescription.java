package com.prescription.model;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the prescription table.
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prescription_date", nullable = false)
    private Date prescriptionDate;

    @Column(name = "patient_name", length = 200, nullable = false)
    private String patientName;

    @Column(name = "patient_age_year", nullable = false)
    private Integer patientAgeYear;

    @Column(name = "patient_age_month", nullable = false)
    private Integer patientAgeMonth;

    @Column(name = "patient_gender", nullable = false)
    private Integer patientGender;

    @Column(name = "diagnosis", length = 500)
    private String diagnosis;

    @Column(name = "medicines", length = 500)
    private String medicines;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "next_visit_date")
    private Date nextVisitDate;

    public Prescription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
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

    public Date getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }
}