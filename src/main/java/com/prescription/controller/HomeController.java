package com.prescription.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for Home
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
@Controller
public class HomeController {

    /**
     * Go the the login page
     * @return String viewName
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * Show all prescriptions
     * @return String viewName
     */
    @GetMapping(value = "/")
    public String showAllPrescriptions() {
        return "redirect:prescription/list";
    }

}

