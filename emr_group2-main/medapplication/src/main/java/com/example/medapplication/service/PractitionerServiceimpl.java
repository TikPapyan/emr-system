package com.example.medapplication.service;

import com.example.medapplication.model.Practitioner;
import com.example.medapplication.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PractitionerServiceimpl implements PractitionerService {
    @Autowired
    private PractitionerRepository practitionerRepository;

    @Override
    public Practitioner savePractitioner(Practitioner practitioner){
        return practitionerRepository.save(practitioner);
    }
    @Override
    public List<Practitioner> getAllPractitioners(){ return practitionerRepository.findAll();}
}
