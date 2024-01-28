package com.example.hospitalmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalmanagement.model.Appointements;
import com.example.hospitalmanagement.model.Doctor;
import com.example.hospitalmanagement.repository.AppointementsRepository;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AppointmentsController {
	@Autowired
	AppointementsRepository repository;
	
	@Autowired
	private DoctorRepository repo; 
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	 @Value("${spring.mail.username}") private String sender;
	 
	private  static final String ACCOUNT_SID="AC866d2f3cf545641a1a2e50c8b169872f";
	private  static final String AUTH_TOKEN="da747688f986906ed88da906ba21c179";
	 
	
	public void sendSimpleEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        this.javaMailSender.send(message);
    }
	
	@PostMapping("/appointement")
	public Appointements insertAppointement(@RequestBody Appointements appointement)
	{
        Doctor doc=repo.findById(appointement.getVisitedDoctor().getId()).get();
        doc.setPatientsAttended(doc.getPatientsAttended()+1);
        repo.save(doc);
        Appointements app=repository.save(appointement);
        String body="Dear "+app.getPatient().getName()+",\n\nThis is to confirm your appointment with Dr."+app.getVisitedDoctor().getName()+" on "+app.getDateOfVisit()+".\n\nThank you for visiting us.\n\nRegards,\nYourHealthInCare.";
        sendSimpleEmail(app.getPatient().getEmail(),"Appointment confirmation",body);
        sendSMS(app.getPatient().getName(),app.getPatient().getContact(),body);
        return app;
	}
	
	public void sendSMS(String user,String contact,String body) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
                new com.twilio.type.PhoneNumber(contact),
                new com.twilio.type.PhoneNumber("+14195566593"),
                body)
            .create();
        System.out.println(message.getSid());
	}
}
