package com.example.hospitalmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctors")
public class Doctor {

	@Id
	private int id;
	private String name;
	private int age;
	private String specialist;
	private int patientsAttended;
	public Doctor(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public int getPatientsAttended() {
		return patientsAttended;
	}
	public void setPatientsAttended(int patientsAttended) {
		this.patientsAttended = patientsAttended;
	}
	public Doctor(int id, String name, int age, String specialist, int patientsAttended) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.specialist = specialist;
		this.patientsAttended = patientsAttended;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", specialist=" + specialist
				+ ", patientsAttended=" + patientsAttended + "]";
	}
	
}
