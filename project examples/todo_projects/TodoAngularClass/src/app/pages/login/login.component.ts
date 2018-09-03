import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  inputUser: User;
  validUser: any;
  constructor(private httpClient: HttpClient) { }

  // this method is for initization of variables if needed
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
    this.httpClient.post('http://localhost:8085/TodoList-Restful-API/login', user).subscribe(
      succ => this.validUser = succ, err => console.log('login failed')
    );
    console.log(this.inputUser);
  }


}
