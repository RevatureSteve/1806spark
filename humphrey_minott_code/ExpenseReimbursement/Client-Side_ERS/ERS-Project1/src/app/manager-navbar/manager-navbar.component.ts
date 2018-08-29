import { ManagerServiceService } from './../manager-service.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginServiceService } from '../login-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager-navbar',
  templateUrl: './manager-navbar.component.html',
  styleUrls: ['./manager-navbar.component.css']
})
export class ManagerNavbarComponent implements OnInit {

  dbUser: User;
  allEmployee: User[];

  constructor(private loginService: LoginServiceService, private ROUTE: Router,private managerService:ManagerServiceService) { }

  ngOnInit() {
    this.dbUser = this.loginService.getUser();
  }

  viewEmployees: boolean =false;
  newRequest: boolean =false;
  viewRequest: boolean = false;
  profile: boolean = false;
  logout: boolean = false;
  create: boolean = false;

  clickNewRequest(){
    this.newRequest =true;
    this.viewRequest = false;
    this.profile = false;
    this.logout = false;
    this.viewEmployees =false;
    this.create =false;
  }
  clickRegister(){
    this.newRequest =false;
    this.viewRequest = false;
    this.profile = false;
    this.logout = false;
    this.viewEmployees =false;
    this.create =true;
  }

  clickViewRequest(){
    this.newRequest =false;
    this.viewRequest = true;
    this.profile = false;
    this.logout = false;
    this.viewEmployees =false;
    this.create =false;
  }
  clickViewEmployees(){
    this.newRequest =false;
    this.viewRequest = false;
    this.profile = false;
    this.logout = false;
    this.viewEmployees =true;
    this.create =false;
  }

  clickUpdateProfile(){
    this.newRequest =false;
    this.viewRequest = false;
    this.profile = true;
    this.logout = false;
    this.viewEmployees =false;
    this.create =false;
  }

  clickLogOut(){
    this.newRequest =false;
    this.viewRequest = false;
    this.profile = false;
    this.logout = true;
    this.viewEmployees =false;
    this.create =false;
  }

  logOut(){

    this.ROUTE.navigate(['login']);
  }

}