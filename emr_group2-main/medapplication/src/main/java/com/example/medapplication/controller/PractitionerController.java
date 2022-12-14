package com.example.medapplication.controller;


import com.example.medapplication.model.Practitioner;
import com.example.medapplication.service.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practitioner")
@CrossOrigin
public class PractitionerController {
    private PractitionerService practitionerService;

    @PostMapping("/add")
    public String add(@RequestBody Practitioner practitioner){
        practitionerService.savePractitioner(practitioner);
        return "New practitioner is added";
    }
    @GetMapping("/getAll")
    public List<Practitioner> getAllPractitioners(){ return practitionerService.getAllPractitioners();}
}
