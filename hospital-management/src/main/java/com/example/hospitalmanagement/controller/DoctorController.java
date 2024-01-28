package com.example.hospitalmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalmanagement.model.Doctor;
import com.example.hospitalmanagement.repository.DoctorRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DoctorController {

	@Autowired
	private DoctorRepository repository;
	
	@GetMapping(value="/appointement",params="specialist")
	public List<Doctor> getDoctorBySpecialization(@RequestParam String specialist)
	{
		return repository.findBySpecialist(specialist);
	}
	@GetMapping(value="/doctor",params="name")
	public Doctor getDoctorByName(@RequestParam String name)
	{	
		return repository.findByName(name);
	}
	@GetMapping(value="/doctor")
	public List<Doctor> getDoctor()
	{
		
		return repository.findAll();
	}
	
	@PostMapping(value="/doctor")
	public Doctor addDoctor(@RequestBody Doctor doctor)
	{
		
		return repository.save(doctor);
	}
	
}
