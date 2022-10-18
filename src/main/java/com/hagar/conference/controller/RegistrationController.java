package com.hagar.conference.controller;

import com.hagar.conference.model.Registration;
import com.hagar.conference.model.RegistrationReport;
import com.hagar.conference.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {


    @Autowired
    private RegistrationService registrationService;

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration")Registration registration){

        return "registration";
    }
    @GetMapping("registrations")
    public @ResponseBody List<Registration> getRegistrations(){
        List<Registration> registrations = registrationService.findAll();
        return registrations;
    }

    @GetMapping("registrations-reports")
    public @ResponseBody List<RegistrationReport> getRegistrationsReports(){
        List<RegistrationReport> registrationsReports = registrationService.findAllReports();
        return registrationsReports;
    }
    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute("registration")  Registration registration,
                                  BindingResult result){
        if(result.hasErrors()){
            System.out.println("there is some error");
            return "registration";
        }
        else {
            registrationService.addRegistration(registration);
        }

        System.out.println("Registration name :"+registration.getName());
        return "redirect:registration";
    }

    @PostMapping("registration/update")
    public @ResponseBody Registration updateRegistration(@Valid @ModelAttribute("registration")
                                                             Registration registration,
                                                         BindingResult result){
        return registrationService.addRegistration(registration);
    }
}
