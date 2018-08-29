import { LoginServiceService } from './../login-service.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-page',
  templateUrl: './employee-page.component.html',
  styleUrls: ['./employee-page.component.css']
})
export class EmployeePageComponent implements OnInit {

  dbUser:User;
  manager:boolean;
  employee:boolean;
  constructor(private loginService:LoginServiceService, private ROUTES: Router) { 
    this.dbUser = this.loginService.getUser();
    
  }

  ngOnInit() {
    console.log(this.dbUser);
    this.dbUser = this.loginService.getUser();

    if(!this.dbUser){
      this.ROUTES.navigate(['login']);
    }
    if(this.dbUser.positionId==1){
      this.manager=true;
      this.employee=false;
    }
    else{
      this.manager=false;
      this.employee=true;
    }
  }

}
