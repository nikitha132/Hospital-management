import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { DoctorService } from './doctor.service';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Doctor } from './doctor';

describe('DoctorService', () => {
  let service: DoctorService;
  let http:HttpClient;
  let httpController:HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
    imports:[HttpClientTestingModule],
    providers:[DoctorService]
  });
    service = TestBed.inject(DoctorService);
    http=TestBed.inject(HttpClient);
    httpController=TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
    expect(service).toBeDefined();
  });

  it('doctor get api', () => {
    let params=new HttpParams().set('name','Dr.Anna');
    expect(params.toString()).toBe("name=Dr.Anna");
    let params1=new HttpParams().set('specialist','Allergist');
    expect(params1.toString()).toBe("specialist=Allergist");
    const expectedDoctor={id:1,age:25,name:'Dr.Anna',patientsAttended:1,specialist:'Allergist'}as Doctor;
    service.getDoctorInfoByName('Dr.Anna').subscribe(data=>expect(data).toEqual(expectedDoctor),fail);
    const req=httpController.expectOne(service.baseUrl);
    expect(req.request.method).toEqual('GET');
    req.flush(expectedDoctor); 
    service.getDoctorInfoBySpecialist('Allergist').subscribe(data=>expect(data.length).toBeGreaterThan(0),fail);
    const req1=httpController.expectOne(service.baseUrl);
    expect(req1.request.method).toEqual('GET');   
  });
});
