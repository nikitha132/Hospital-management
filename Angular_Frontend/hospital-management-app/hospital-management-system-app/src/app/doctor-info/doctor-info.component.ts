import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctor-info',
  templateUrl: './doctor-info.component.html',
  styleUrls: ['./doctor-info.component.css']
})
export class DoctorInfoComponent implements OnInit {

  doctors: Doctor[] = [];
  doctor!: Doctor;
  name!:string;
  constructor(private service:DoctorService,private router:Router) {}

  ngOnInit(): void {this.getDoctors()}
   getDoctorsByName()
  {
    return this.service.getDoctorInfoByName(this.name).subscribe(data=>{
      this.doctor=data;
      this.goToDoctors();
    });
  }

  getDoctors()
  {
    return this.service.getDoctorInfo().subscribe(data=>{
      this.doctors=data;
    });
  }

  goToDoctors()
  {
    return this.router.navigate(['/doctor']);
  }
  onSubmit()
  {
    this.getDoctorsByName();
  }
}
