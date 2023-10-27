package com.example.hospitalmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagement.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
	
	Doctor findByName(String name);
	List<Doctor> findBySpecialist(String specialist);

}
