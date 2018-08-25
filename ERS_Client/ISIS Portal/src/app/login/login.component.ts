import { UsersService } from './../users-service';
import { HttpClient } from '@angular/common/http';
import { Users } from './../models/users';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
inputUser: Users;
email: string;
password: string;
  
  constructor(private httpClient: HttpClient,
  private service : UsersService) { }

  ngOnInit() {


  }

login() {
console.log(this.email);
console.log(this.password);
this.validateUser(this.email, this.password);
}


validateUser(email, password): void  {
  console.log(this.email + this.password)
  this.httpClient.post<Users>('http://localhost:8080/ERS/LoginServlet?email=' + this.email + '&password=' + this.password, this.inputUser)
  .subscribe(data => {
    console.log(data);
    this.inputUser = data;
  } )




}
}
