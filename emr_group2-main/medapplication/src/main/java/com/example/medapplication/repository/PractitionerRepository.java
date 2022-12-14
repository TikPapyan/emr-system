package com.example.medapplication.repository;

import com.example.medapplication.model.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PractitionerRepository extends JpaRepository<Practitioner, Integer> {
}
