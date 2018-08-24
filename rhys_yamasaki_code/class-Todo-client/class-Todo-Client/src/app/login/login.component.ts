import { User } from './../models/user';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from '../../../node_modules/rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputUser: User;
  validUser: User;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.inputUser = {
      userId: 0,
      username: '',
      password: '',
      userTasks: null
    };
  }

  login() {
    console.log(this.inputUser);
    this.loginUser(this.inputUser);
  }

  loginUser(user: User) {
    this.httpClient.post<User>('http:lcalhost:8080/Todo-Restful-API/login', user).subscribe(
      succ => this.validUser = succ, err => console.log('login failed')
    );
  }

}
