import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

   baseUrl="http://localhost:8080/api/v1/doctor";
   Url="http://localhost:8080/api/v1/insertPatient";
  constructor(private httpClient:HttpClient) { }
  getDoctorInfo():Observable<Doctor[]>
  {
    return this.httpClient.get<Doctor[]>(`${this.baseUrl}`);
  }
  getDoctorInfoByName(name:string):Observable<Doctor>
  {
    let params=new HttpParams();
    params=params.append('name',name);
    return this.httpClient.get<Doctor>(`${this.baseUrl}`,{params:params});
  }
  getDoctorInfoBySpecialist(specialist:string):Observable<Doctor[]>
  {
    let params=new HttpParams();
    params=params.append('specialist',specialist);
    return this.httpClient.get<Doctor[]>(`${this.Url}`,{params:params});
  }

}
