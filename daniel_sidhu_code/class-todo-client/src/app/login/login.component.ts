import { Component, OnInit } from '@angular/core';
import { User } from '';
import { HttpClient } from '@angular';
import { User } from '../models/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']

})
export class LoginComponent implements OnInit {

  inputUser: User;
  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.inputUser = {
      userId: 0,
      usrname: '',
      password: '',
      userTasks: null
    };
  }

  login() {
    console.log(this.inputUser);
    this.loginUser(this.inputUser);
  }

  loginUser(user: User) {
    this.httpClient.post('', user).subscribe(
      succ => console.log(succ), err => console.log('login failed')
    );
  }
}
