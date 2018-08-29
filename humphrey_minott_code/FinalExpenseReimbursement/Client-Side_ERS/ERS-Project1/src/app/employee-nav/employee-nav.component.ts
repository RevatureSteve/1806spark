import { LoginServiceService } from './../login-service.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-nav',
  templateUrl: './employee-nav.component.html',
  styleUrls: ['./employee-nav.component.css']
})
export class EmployeeNavComponent implements OnInit {

  dbUser: User;


  constructor(private loginService: LoginServiceService, private ROUTE: Router) { }

  ngOnInit() {
    this.dbUser = this.loginService.getUser();
  }


  newRequest: boolean =false;
  viewRequest: boolean = false;
  profile: boolean = false;
  logout: boolean = false;

  clickNewRequest(){
    this.newRequest =true;
    this.viewRequest = false;
    this.profile = false;
    this.logout = false;
  }

  clickViewRequest(){
    this.newRequest =false;
    this.viewRequest = true;
    this.profile = false;
    this.logout = false;
  }

  clickUpdateProfile(){
    this.newRequest =false;
    this.viewRequest = false;
    this.profile = true;
    this.logout = false;
  }

  clickLogOut(){
    this.newRequest =false;
    this.viewRequest = false;
    this.profile = false;
    this.logout = true;
  }

  logOut(){

    this.ROUTE.navigate(['login']);
  }

}
