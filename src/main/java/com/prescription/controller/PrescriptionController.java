package com.prescription.controller;


import com.prescription.exception.RecordNotFoundException;
import com.prescription.form.PrescriptionForm;
import com.prescription.form.PrescriptionSearchForm;
import com.prescription.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class for prescription(s)
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@Controller
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionService service;

    /**
     * This method is used to show index page with all the prescriptions
     *
     * @param model this is the model object
     * @return String view name.
     */
    @GetMapping(value = {"/list"})
    public String showAllPrescription(Model model) {
        service.viewInit(null, model);
        return "index";
    }

    /**
     * This method is used to save prescription
     *
     * @param prescriptionSearchForm PrescriptionSearchForm
     * @param model                  this is the model object
     * @return String view name.
     */
    @PostMapping("/search")
    public String searchPrescription(@ModelAttribute("prescriptionSearchForm") PrescriptionSearchForm prescriptionSearchForm,
                                     Model model) {
        service.viewInit(prescriptionSearchForm, model);
        return "index";
    }

    /**
     * This method is used to show prescription add form
     *
     * @param model this is the model object
     * @return String view name.
     */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        service.viewInitPrescription(model, null);
        return "add-prescription";
    }

    /**
     * This method is used to save prescription
     *
     * @param prescriptionForm PrescriptionForm
     * @param result           BindingResult
     * @param model            this is the model object
     * @return String view name.
     * @throws RecordNotFoundException exception
     */
    @PostMapping("/save")
    public String addPrescription(@Valid @ModelAttribute("prescriptionForm") PrescriptionForm prescriptionForm,
                                  BindingResult result, Model model) throws RecordNotFoundException {
        if (result.hasErrors()) {
            service.viewInitPrescription(model, prescriptionForm);
            return "add-prescription";
        }
        service.registry(prescriptionForm);
        return "redirect:list";
    }

    /**
     * This method is used to show edit form
     *
     * @param id    long value for prescriptionId
     * @param model this is the model object
     * @return String view name.
     * @throws RecordNotFoundException exception
     */
    @GetMapping("/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) throws RecordNotFoundException {
        PrescriptionForm prescriptionForm = service.getPrescriptionForm(id);
        service.viewInitPrescription(model, prescriptionForm);
        model.addAttribute("prescriptionForm", prescriptionForm);
        return "update-prescription";
    }

    /**
     * This method is used to show edit form
     *
     * @param prescriptionForm PrescriptionForm
     * @param result           BindingResult
     * @param model            this is the model object
     * @return String view name.
     * @throws RecordNotFoundException exception
     */
    @PostMapping("/update")
    public String updatePrescription(@Valid @ModelAttribute("prescriptionForm") PrescriptionForm prescriptionForm,
                                     BindingResult result, Model model) throws RecordNotFoundException {
        if (result.hasErrors()) {
            service.viewInitPrescription(model, prescriptionForm);
            return "update-prescription";
        }
        service.registry(prescriptionForm);
        return "redirect:list";
    }

    /**
     * This method is used to show edit form
     *
     * @param id    long value for prescriptionId
     * @param model this is the model object
     * @return String view name.
     * @throws RecordNotFoundException exception
     */
    @GetMapping("/delete/{id}")
    public String deletePrescription(@PathVariable("id") long id, Model model) throws RecordNotFoundException {
        service.deletePrescriptionById(id, model);
        service.viewInit(null, model);
        return "index";
    }


    /**
     * This method is used to show index page with all the prescriptions
     *
     * @param model this is the model object
     * @return String view name.
     */
    @GetMapping(value = {"/view-report"})
    public String showPrescriptionReport(Model model) {
        service.generatePrescriptionReportView(model);
        return "report";
    }
}
