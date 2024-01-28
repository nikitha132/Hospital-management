package com.example.hospitalmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hospitalmanagement.model.Doctor;
import com.example.hospitalmanagement.model.Patient;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.repository.PatientRepository;

@SpringBootTest
class HospitalManagementApplicationTests {

	@Autowired
	DoctorRepository d_repo;
	@Autowired
	PatientRepository p_repo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void createPatient() throws ParseException
	{
		Patient p=new Patient();
		p.setName("Surya");
		p.setEmail("Surya@gmail.com");
		p.setContact(9381202121L);
		assertNotNull(p_repo.save(p));
	}	
	
	@Test
	public void readPatients()
	{
		List<Patient> patients=p_repo.findAll();
		assertFalse(patients.size()==0);		
	}
	
	@Test
	public void readPatientById()
	{
		Patient p=p_repo.findById(6).get();
		assertEquals("Raksha",p.getName());
	}
	
	@Test
	public void readDoctors()
	{
		List<Doctor> doctors=d_repo.findAll();
		assertFalse(doctors.size()==0);
		
	}
	@Test
	public void readDoctorByName()
	{
	Doctor doctor=d_repo.findByName("Dr.Anna");
	assertEquals("Dr.Anna",doctor.getName());
	
	}
	@Test
	public void readDoctorsBySpecialization()
	{
		List<Doctor> doctors=d_repo.findBySpecialist("Physician");
		assertFalse(doctors.size()==0);
	}

}
