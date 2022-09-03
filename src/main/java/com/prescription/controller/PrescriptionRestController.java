package com.prescription.controller;

import com.prescription.model.Prescription;
import com.prescription.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller class for prescription(s)
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@RestController
public class PrescriptionRestController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    /**
     * REST API response end point for all prescription
     * @return List prescription
     */
    @GetMapping("/api/v1/prescription")
    List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }
}
