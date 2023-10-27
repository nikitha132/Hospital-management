import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { PatientService } from './patient.service';
import { Patient } from './patient';
import { request } from 'http';

describe('PatientService', () => {
  let service: PatientService;
  let http:HttpClient;
  let httpController:HttpTestingController; 
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
    providers:[PatientService]
    });
    service = TestBed.inject(PatientService);
    http=TestBed.inject(HttpClient);
    httpController=TestBed.inject(HttpTestingController);
  });
  afterEach(()=>{
     httpController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
    expect(service).toBeDefined();
  });

  it('patient get api', () => {
    let params=new HttpParams().set('id',1);
    expect(params.toString()).toBe("id=1");
    const expectedPatient={name:'Prakash',visitedDoctor:'Dr.Anna',dateOfVisit:new Date('09-09-2001'),prescription:'Antihistamine'}as Patient;
    service.getPatientInfoById(5).subscribe(data=>expect(data).toEqual(expectedPatient),fail);
    const req=httpController.expectOne(service.baseUrl);
    expect(req.request.method).toEqual('GET');
    req.flush(expectedPatient);
    const expectedPatient1=new Patient();
    service.getPatientInfoById(0).subscribe(data=>expect(data).toEqual(expectedPatient1),fail);
    const req1=httpController.expectOne(service.baseUrl);
    req1.flush(expectedPatient);
  });
  it('patient post api',()=>{
     const newPatient:Patient={name:'Debashish',visitedDoctor:'Dr.Oliver',dateOfVisit:new Date('20-09-2020'),prescription:'Retinoids'};
     service.insertPatientInfo(newPatient).subscribe(data=>expect(data).toEqual(newPatient),fail);
     const req=httpController.expectOne(service.baseUrl);
     expect(req.request.method).toEqual('POST');
     expect(req.request.body).toEqual(newPatient);
     const response=new HttpResponse({status:201,statusText:'Created',body:newPatient});
     req.event(response);
  });
});
