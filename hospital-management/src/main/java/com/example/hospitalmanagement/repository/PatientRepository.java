package com.example.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagement.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
