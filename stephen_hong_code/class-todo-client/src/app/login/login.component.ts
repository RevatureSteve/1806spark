import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  inputUser: User;
  constructor(private HttpClient: HttpClient) { }

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
    this.HttpClient.post('http://localhost:8085/TodoList-Restful-API/login', user).subscribe(
      succ => console.log(succ), err => console.log('login failed')
    );
  }

}
