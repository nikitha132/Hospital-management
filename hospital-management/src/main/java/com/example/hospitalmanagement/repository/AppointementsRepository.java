package com.example.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagement.model.Appointements;

public interface AppointementsRepository extends JpaRepository<Appointements,Integer> {

}
