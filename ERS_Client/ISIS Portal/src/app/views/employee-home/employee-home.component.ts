import { UsersService } from './../../users-service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/Users';


@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {
 
  // firstname = this.usr.first;
  // lastname = this.usr.last;


  links = [
    'Home',
    'Agent Profile',
    'Missions',
    'Agent Status'
  ];
  agents: Users[];



  constructor(private httpClient: HttpClient, private service: UsersService) { }
  ngOnInit() {

    this.getUser();

  }

  getUser() {
    console.log("Checking logged in user.")
   return this.service.currentLoggedUser().first;
    // console.log();

  }
}
