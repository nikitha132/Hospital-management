package com.example.hospitalmanagement.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name="appointements")
public class Appointements {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor visitedDoctor;
	private Date dateOfVisit;
	private String prescription;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Appointements() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(Doctor visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public Appointements(int id, Patient patient, Doctor visitedDoctor, Date dateOfVisit, String prescription) {
		super();
		this.id = id;
		this.patient = patient;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}
	@Override
	public String toString() {
		return "Appointements [id=" + id + ", patient=" + patient + ", visitedDoctor=" + visitedDoctor
				+ ", dateOfVisit=" + dateOfVisit + ", prescription=" + prescription + "]";
	}
	
	
	
}
