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

  constructor(private httpClient: HttpClient, private routes: Router ) { }

  ngOnInit() {
    this.validUser = null;
    // Setting the input value into the parameters below
    this.inputUser = {
      u_Id: 0,
      email: '',
      password: '',
      fname: '',
      name: '',
      pos_Id: 0
    };
  }

  // verifying logic for user that's logging in
  loggingInUser(user: Users): void {
    console.log('service: loggingInUser');
    this.httpClient.post('http://localhost:8080/ProjectOne/reimbursement/v', user).subscribe(
      succ => {
        console.log('login successful');
        console.dir(succ);
        localStorage.setItem('user', JSON.stringify(succ));
        this.setUser();

        // to redirect to either manager or employee
        if (this.validUser.pos_Id === 1) {
          this.routes.navigate(['/overseer']);
        }
        if (this.validUser.pos_Id  === 2) {
          this.routes.navigate(['/dweller']);
        }
      },
      err => alert('login failed')
    );
  }

  // function to set user if the user is VALID!
  setUser() {
    this.validUser = JSON.parse(localStorage.getItem('user'));
  }

  // login function to set valid user to inputUser
  login() {
    this.loggingInUser(this.inputUser);
  }
}
