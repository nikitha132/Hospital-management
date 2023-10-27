import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  doctors!:Doctor[];
    constructor(private router:Router) { }

  ngOnInit(): void { 
  }
  clicked(specialist:string)
  {
    this.gotoInsertPatientPage(specialist);
  }
  gotoInsertPatientPage(specialist:string)
  {
    return this.router.navigate(['/insertPatient'],
    {
      queryParams:{specialist:specialist},
      queryParamsHandling:'merge'
    });
  }
}
