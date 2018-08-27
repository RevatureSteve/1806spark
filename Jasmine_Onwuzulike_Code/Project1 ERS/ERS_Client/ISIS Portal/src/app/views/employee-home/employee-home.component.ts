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
    'Agent Status',
    'Logout'
  ];
  agents: Users[];
 usr = this.service.currentLoggedUser();
user = JSON.stringify(this.usr);
uu = this.user.valueOf();
final = JSON.parse(this.uu);


  constructor(private httpClient: HttpClient, private service: UsersService) { }
  ngOnInit() {
    console.log("Employee....")
    let usr = this.service.currentLoggedUser();
    let user = JSON.stringify(usr);
    
    // let first = user.first;
    // let last = user.last;
    let uu = user.valueOf();
    let final = JSON.parse(uu);
    console.log(final.email);

  }


}
