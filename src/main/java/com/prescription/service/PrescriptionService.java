package com.prescription.service;

import com.prescription.dto.PrescriptionReport;
import com.prescription.exception.RecordNotFoundException;
import com.prescription.form.PrescriptionForm;
import com.prescription.form.PrescriptionSearchForm;
import com.prescription.model.Prescription;
import com.prescription.repository.PrescriptionRepository;
import com.prescription.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

/**
 * Service class for prescription
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@Service
public class PrescriptionService {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    /**
     * This method used to initialized the PrescriptionForm
     *
     * @param model            this is the model object
     * @param prescriptionForm PrescriptionForm
     */
    public void viewInitPrescription(Model model, PrescriptionForm prescriptionForm) {
        if (prescriptionForm == null) {
            prescriptionForm = new PrescriptionForm();
        }
        model.addAttribute(prescriptionForm);
    }

    /**
     * viewInit PrescriptionSearchForm
     *
     * @param prescriptionSearchForm PrescriptionSearchForm
     * @param model                  Model
     */
    public void viewInit(PrescriptionSearchForm prescriptionSearchForm, Model model) {

        if (prescriptionSearchForm == null) {
            prescriptionSearchForm = new PrescriptionSearchForm();

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
            Date currentDt =cal.getTime();

            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date targetDt = cal.getTime();

            prescriptionSearchForm.setSearchDtSt(Util.dtToStr(currentDt));
            prescriptionSearchForm.setSearchDtTo(Util.dtToStr(targetDt));
        }

        Date searchDtSt = Util.strToDt(prescriptionSearchForm.getSearchDtSt());
        Date searchDtTo = Util.strToDt(prescriptionSearchForm.getSearchDtTo());

        if (searchDtSt == null) {
            searchDtSt = Util.getDefaultFirstDate();
        }
        if (searchDtTo == null) {
            searchDtTo = Util.getDefaultFutureDate();
        }
        List<Prescription> prescriptionList = getPrescriptionsByDateRange(searchDtSt, searchDtTo);
        prescriptionSearchForm.setPrescriptionList(prescriptionList);
        model.addAttribute("prescriptionSearchForm", prescriptionSearchForm);
    }

    /**
     * Set details
     *
     * @param model Model
     */
    public void generatePrescriptionReportView(Model model) {
        List<PrescriptionReport> prescriptionReportList = prescriptionRepository.findPrescriptionReportDetailsCount();
        model.addAttribute("prescriptionReportList", prescriptionReportList);
    }

    /**
     * This method used to get all the prescriptions
     *
     * @return List prescriptions
     */
    public List<Prescription> getAllPrescriptions() {
        List<Prescription> result = prescriptionRepository.findByOrderByPrescriptionDateAsc();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * This method used to get all the prescriptions by date range
     *
     * @return List prescriptions
     */
    public List<Prescription> getPrescriptionsByDateRange(Date searchDtSt, Date searchDtTo) {
        List<Prescription> result = prescriptionRepository.findByPrescriptionDateBetweenOrderByPrescriptionDateAsc(searchDtSt, searchDtTo);
        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * This method used to get the prescription by it's id
     *
     * @param id long value
     * @return prescription Prescription
     * @throws com.prescription.exception.RecordNotFoundException exception
     */
    public Prescription getPrescriptionById(Long id) throws RecordNotFoundException {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);

        if (prescription.isPresent()) {
            return prescription.get();
        } else {
            throw new RecordNotFoundException("No Prescription record exist for given id");
        }
    }

    /**
     * This method used to registry the prescription
     *
     * @param prescriptionForm PrescriptionForm
     * @throws RecordNotFoundException exception
     */
    public void registry(PrescriptionForm prescriptionForm) throws RecordNotFoundException {
        Prescription prescription = new Prescription();
        if (prescriptionForm.getId() != null) {
            prescription = getPrescriptionById(prescriptionForm.getId());
        }
        prescription.setPrescriptionDate(Util.strToDt(prescriptionForm.getPrescriptionDate()));
        prescription.setPatientName(prescriptionForm.getPatientName());
        prescription.setPatientAgeYear(prescriptionForm.getPatientAgeYear());
        prescription.setPatientAgeMonth(prescriptionForm.getPatientAgeMonth());
        prescription.setPatientGender(prescriptionForm.getPatientGender());
        prescription.setDiagnosis(prescriptionForm.getDiagnosis());
        prescription.setMedicines(prescriptionForm.getMedicines());
        prescription.setDiagnosis(prescriptionForm.getDiagnosis());
        prescription.setNextVisitDate(Util.strToDt(prescriptionForm.getNextVisitDate()));
        prescriptionRepository.save(prescription);
    }

    /**
     * This method used to delete the prescription by it's id
     *
     * @param id    long value
     * @param model this is the model object
     * @throws RecordNotFoundException exception
     */
    public void deletePrescriptionById(@PathVariable("id") long id, Model model) throws RecordNotFoundException {
        Prescription prescription = getPrescriptionById(id);
        prescriptionRepository.delete(prescription);
        model.addAttribute("prescriptions", prescriptionRepository.findAll());
    }

    /**
     * This method used to get the prescriptionForm by it's id
     *
     * @param id long value
     * @return prescriptionForm PrescriptionForm
     * @throws RecordNotFoundException exception
     */
    public PrescriptionForm getPrescriptionForm(Long id) throws RecordNotFoundException {
        PrescriptionForm prescriptionForm = new PrescriptionForm();
        Prescription prescription;
        if (id != null) {
            prescription = getPrescriptionById(id);
            prescriptionForm.setId(prescription.getId());
            prescriptionForm.setPrescriptionDate(Util.dtToStr(prescription.getPrescriptionDate()));
            prescriptionForm.setPatientName(prescription.getPatientName());
            prescriptionForm.setPatientAgeYear(prescription.getPatientAgeYear());
            prescriptionForm.setPatientAgeMonth(prescription.getPatientAgeMonth());
            prescriptionForm.setPatientGender(prescription.getPatientGender());
            prescriptionForm.setDiagnosis(prescription.getDiagnosis());
            prescriptionForm.setMedicines(prescription.getMedicines());
            prescriptionForm.setNextVisitDate(Util.dtToStr(prescription.getNextVisitDate()));
        }
        return prescriptionForm;
    }

}