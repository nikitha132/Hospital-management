import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';


@Component({
  selector: 'app-insert-patient',
  templateUrl: './insert-patient.component.html',
  styleUrls: ['./insert-patient.component.css']
})
export class InsertPatientComponent implements OnInit {

  doctors:Doctor[]=[];
  patient:Patient=new Patient;
  specialist:any;
  submitted!:boolean;
  constructor(private service:PatientService,private route:ActivatedRoute,private d_service:DoctorService) {}
  ngOnInit(): void {
    this.submitted=false;
    this.specialist=this.route.snapshot.queryParamMap.get('specialist');
    this.d_service.getDoctorInfoBySpecialist(this.specialist).subscribe(data=>{this.doctors=data;console.log(data)});
  }
  
  savePatientInfo()
  {
    this.service.insertPatientInfo(this.patient).subscribe(data=>
      {
      console.log(data);
    },error=>console.log(error));
    
  }

  onSubmit(insertPatient:NgForm)
  {
    this.submitted=true;
    this.savePatientInfo();
    insertPatient.reset();
  }
}
