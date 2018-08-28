import { LoggedInService } from './../../logged-in.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users } from './../../models/Users';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputUser: Users; // Setting the information inputted as inputUser
  validUser = null; // Setting the validUser as null

  constructor(private httpClient: HttpClient, private routes: Router, private loggedInService: LoggedInService ) { }

  ngOnInit() {
    this.validUser = null;
    // Setting the input value into the parameters below
  }

  // verifying logic for user that's logging in
  loggingInUser(email, password): void {
    console.log('service: loggingInUser');
    this.loggedInService.getUser(email, password).subscribe(
      succ => {
        console.log('login successful');
        console.dir(succ);
        this.changePage(succ);

        // to redirect to either manager or employee
        // if (this.inputUser.pos_Id === 1) {
        //   this.routes.navigate(['/overseer']);
        // }
        // if (this.validUser.pos_Id  === 2) {
        //   this.routes.navigate(['/dweller']);
        // }
      },
      err => alert('login failed')
    );
  }

  changePage(inputUser) {
    this.inputUser = inputUser;
    if (inputUser) {
      this.loggedInService.setLoggedInUser(inputUser);
      console.log(inputUser);
      if (inputUser.pos_Id === 1) {
        this.routes.navigate(['/overseer']);
        alert('Welcome Overseer');
      } else {
        alert('Welcome Vault Dweller' + inputUser.u_Id);
        this.routes.navigate(['/dweller']);
      }
    } else {
      alert('login failed');
      this.routes.navigate(['/login']);
    }
  }


  // function to set user if the user is VALID!
  // setUser() {
  //   this.validUser = JSON.parse(localStorage.getItem('user'));
  // }

  // login function to set valid user to inputUser
  // login() {
  //   this.loggingInUser(this.inputUser);
  // }
}
