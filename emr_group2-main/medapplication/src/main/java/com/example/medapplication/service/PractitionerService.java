package com.example.medapplication.service;

import com.example.medapplication.model.Practitioner;

import java.util.List;

public interface PractitionerService {
    public Practitioner savePractitioner(Practitioner practitioner);
    public List<Practitioner> getAllPractitioners();
}
