import { Users } from './../../models/Users';
import { LoginComponent } from './../login/login.component';
import { Component, OnInit } from '@angular/core';
import { DataService } from './../../data.service';
import { LoggedInService } from '../../logged-in.service';

@Component({
  selector: 'app-users-information',
  templateUrl: './users-information.component.html',
  styleUrls: ['./users-information.component.css']
})
export class UsersInformationComponent implements OnInit {
  user: Users;

  constructor(private loggedInService: LoggedInService) { }

  ngOnInit() {
    // setting my user object within this component with my information from the database
    this.user = this.loggedInService.getLoggedInUser();
    console.log(this.user);

  // getUserInfo() {
  //   this.data.getUser().subscribe(
  //     data => this.user = data);
  }
}
