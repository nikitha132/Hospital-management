import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-patient-info',
  templateUrl: './patient-info.component.html',
  styleUrls: ['./patient-info.component.css']
})
export class PatientInfoComponent implements OnInit {

  patient!: Patient;
  id!: number;
  constructor(private service:PatientService,private router:Router) { }

  ngOnInit(): void {}

  getPatientInfoById()
  {
    return this.service.getPatientInfoById(this.id).subscribe(data=>{
      this.patient=data;
      this.goToPatients();
    });
  }
  goToPatients()
  {
    return this.router.navigate(['/patient']);
  }
  onSubmit()
  {
      this.getPatientInfoById();
  }
}
