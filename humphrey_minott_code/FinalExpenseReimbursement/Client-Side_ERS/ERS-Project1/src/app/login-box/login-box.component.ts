import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginServiceService } from '../login-service.service';
import { Router } from '@angular/router';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })}

@Component({
  selector: 'app-login-box',
  templateUrl: './login-box.component.html',
  styleUrls: ['./login-box.component.css']
})


export class LoginBoxComponent implements OnInit {

  dbUser: User;
  validateUser: User;
    constructor(private loginService: LoginServiceService,private ROUTE: Router) { }

  incorrect: boolean = false;
  
  
  ngOnInit() {
    this.validateUser = {
      uId: 0,
      email: "",
      password: "",
      fname: "",
      lname: "",
      positionId: 0,
      employeeReimbursements: null
    };
  }
    loginNow() {
      console.log(this.validateUser);
      this.loginUser(this.validateUser);
    }
  
    loginUser(user: User){
      this.loginService.validLoginUser(user).subscribe(
        succ => {
          this.dbUser = succ;
          this.incorrect = false;
          this.loginService.saveUser(succ);
          this.ROUTE.navigate(['dashboard']);
        }, err => {
          console.log('login failed')
          this.incorrect = true;
        }
        );
    }}