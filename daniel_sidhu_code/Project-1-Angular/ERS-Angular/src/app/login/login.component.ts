import { Component, OnInit, NgModule } from '@angular/core';
import { Users } from '../models/users';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  inputUser: Users;
  validUser = null;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.validUser = null;
    this.inputUser = {
      userId: 0,
      email: '',
      password: '',
      firstName: '',
      lastName: '',
      positionId: 0
    };
  }

  login() {

    this.loginUser(this.inputUser);
  }

  loginUser(user: Users): void {
    console.log('service: loginUser info ' + user.email + ' and ' + user.password);
    this.httpClient.post('http://localhost:8080/Project1/Login', user)
    .subscribe(
      succ => {
        console.log('login successful');
        console.dir(succ);
        localStorage.setItem('user', JSON.stringify(succ));
        this.setUser();
      },
      err => alert('failed login')
    );
  }

  setUser() {
    this.validUser = JSON.parse(localStorage.getItem('user'));
  }

}
