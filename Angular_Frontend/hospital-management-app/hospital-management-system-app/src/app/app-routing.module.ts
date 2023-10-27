import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorInfoComponent } from './doctor-info/doctor-info.component';
import { PatientInfoComponent } from './patient-info/patient-info.component';
import { InsertPatientComponent } from './insert-patient/insert-patient.component';
import { HomeComponent } from './home/home.component';
import 'tslib';
const routes: Routes = [
  {path:"doctor",component:DoctorInfoComponent},
  {path:"patient",component:PatientInfoComponent},
  {path:"insertPatient",component:InsertPatientComponent},
  {path:"",component:HomeComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule { }
