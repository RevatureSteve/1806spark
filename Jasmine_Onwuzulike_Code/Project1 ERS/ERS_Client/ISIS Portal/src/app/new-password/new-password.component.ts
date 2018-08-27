import { Reimbursement } from './../models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-password',
  templateUrl: './new-password.component.html',
  styleUrls: ['./new-password.component.css']
})
export class NewPasswordComponent implements OnInit {

  constructor(private router: Router, private service: UsersService,private httpClient : HttpClient) { }
  uId : number;
  password: string;
  pass: any;
  usr = this.service.currentLoggedUser();
  user = JSON.stringify(this.usr);
  uu = this.user.valueOf();
  final = JSON.parse(this.uu);
  rb : Reimbursement;
  

  ngOnInit() {
  }
  start() {
    console.log(this.final.empId);
    console.log(this.password);
    this.createNewPassword(this.final.empId, this.password);
  }
  createNewPassword (uId: number, password: string) {
    this.httpClient.post("http://localhost:8080/ERS/UpdatePasswordServlet?uId=" + uId + "&password=" + this.password, this.pass)
    .subscribe( data => {
      this.pass = data;
      let final = JSON.parse(this.pass);
      console.log(final);
      if (final =1 ) {
        alert("Your password was successfully changed");
        this.router.navigate(['login']);
      }
      else {
        alert("Attept to change password was unsuccessful.");
      }
    })
  }
 

}
