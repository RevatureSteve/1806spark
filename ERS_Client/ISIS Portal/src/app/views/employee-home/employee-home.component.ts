import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/Users';


@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {
  links = [
    'Home',
    'Agent Profile',
    'Missions',
    'Agent Status'
  ];
  // Harcoded agent for testing
  agent: Users = {
    id:  1,
    first: 'James',
    last: 'Bond',
     email: 'jb@bss.com',
    password: '007',
    position:  2,
   };


   constructor() { }
  ngOnInit() {
  }

}
