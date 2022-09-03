package com.prescription.repository;

import com.prescription.dto.PrescriptionReport;
import com.prescription.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * PrescriptionRepository class for JPA operation
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    /**
     * Get all prescription list by PrescriptionDate desc order.
     *
     * @return List Prescription
     */
    List<Prescription> findByOrderByPrescriptionDateAsc();

    /**
     * Get Prescription data by date range
     *
     * @param searchDtSt Date
     * @param searchDtTo Date
     * @return Prescription list
     */
    List<Prescription> findByPrescriptionDateBetweenOrderByPrescriptionDateAsc(Date searchDtSt, Date searchDtTo);


    /**
     * Get Prescription count by date
     *
     * @return PrescriptionReport count list
     */
    @Query(value = "SELECT new com.prescription.dto.PrescriptionReport(s.prescriptionDate, COUNT(s.prescriptionDate)) " +
            " FROM Prescription s GROUP BY s.prescriptionDate")
    List<PrescriptionReport> findPrescriptionReportDetailsCount();

}
