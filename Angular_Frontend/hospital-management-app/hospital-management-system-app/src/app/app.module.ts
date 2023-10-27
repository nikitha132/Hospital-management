import { NgModule, ViewChild } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MessageModule} from '@syncfusion/ej2-angular-notifications'
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientInfoComponent } from './patient-info/patient-info.component';
import { DoctorInfoComponent } from './doctor-info/doctor-info.component';
import { PatientService } from './patient.service';
import { DoctorService } from './doctor.service';
import { FormsModule } from '@angular/forms';
import { InsertPatientComponent } from './insert-patient/insert-patient.component';
import { HomeComponent } from './home/home.component';
import { AppointementsComponent } from './appointements/appointements.component';
import 'tslib';


@NgModule({
  declarations: [
    AppComponent,
    PatientInfoComponent,
    DoctorInfoComponent,
    InsertPatientComponent,
    HomeComponent,
    AppointementsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MessageModule,
  ],
  providers: [
    DoctorService,
    PatientService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
