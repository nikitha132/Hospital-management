import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {  Observable } from 'rxjs';
import { Patient } from './patient';
@Injectable({
  providedIn: 'root'
})
export class PatientService {

   baseUrl="http://localhost:8080/api/v1/patient";
  constructor(private httpClient:HttpClient) { }
  getPatientInfoById(id:number):Observable<Patient>
  {
    let params=new HttpParams();
    params=params.append('id',id);
    return this.httpClient.get<Patient>(`${this.baseUrl}`,{params:params});
  }
  insertPatientInfo(patient: Patient):Observable<Patient>
  {
    return this.httpClient.post<Patient>(`${this.baseUrl}`,patient);
  }
}
