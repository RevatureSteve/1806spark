import { LoggedInService } from './../../logged-in.service';
import { Reimbursement } from './../../models/Reimbursement';
import { UpdateUserService } from './../../update-user.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Users } from './../../models/Users';
import { LoginComponent } from './../login/login.component';
import { Component, OnInit } from '@angular/core';
import { DataService } from './../../data.service';

@Component({
  selector: 'app-users-information',
  templateUrl: './users-information.component.html',
  styleUrls: ['./users-information.component.css']
})
export class UsersInformationComponent implements OnInit {
  user: Users;
  updateUser: Users;
  reimb: Reimbursement;

  constructor(private loggedInService: LoggedInService, private updateUserService: UpdateUserService,
    private httpClient: HttpClient, private routes: Router) { }

  ngOnInit() {
    // setting my user object within this component with my information from the database
    this.user = this.loggedInService.getLoggedInUser();
    console.log(this.user);
  }

  updatingUser(email, password, fname, lname, u_Id): void {
    console.log('service: updatingUser');
    this.updateUserService.updateUser(email, password, fname, lname, u_Id).subscribe(
      update => {
        console.log('updating your information');
        alert('You have updated your information');
      }
    );
  }
}
