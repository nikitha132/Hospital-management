package com.example.hospitalmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalmanagement.model.Doctor;
import com.example.hospitalmanagement.model.Patient;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.repository.PatientRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {

	@Autowired
	private PatientRepository repository;
	
	@Autowired
	private DoctorRepository repo; 
	
	@GetMapping("/patient")
	public Optional<Patient> getPatient(@RequestParam int id)
	{
		return repository.findById(id);
	}
	@PostMapping("/patient")
	public Patient insertPatient(@RequestBody Patient patient)
	{
        Doctor doc=repo.findByName(patient.getVisitedDoctor());
        doc.setPatientsAttended(doc.getPatientsAttended()+1);
        repo.deleteById(doc.getId());
        repo.save(doc);
        return repository.save(patient);
	}
	
	
}
