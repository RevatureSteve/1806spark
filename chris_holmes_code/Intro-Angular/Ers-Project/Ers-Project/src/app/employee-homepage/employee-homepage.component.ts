import { LoggeduserService } from './../services/loggeduser.service';
import { LoginComponent } from './../login/login.component';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/users';


@Component({
  selector: 'app-employee-homepage',
  templateUrl: './employee-homepage.component.html',
  styleUrls: ['./employee-homepage.component.css']
})
export class EmployeeHomepageComponent implements OnInit {
user: User;


  constructor(private logged: LoggeduserService) { }


  ngOnInit() {
    this.user = this.logged.getloggeduser();
    console.log(this.user);
  }


}
