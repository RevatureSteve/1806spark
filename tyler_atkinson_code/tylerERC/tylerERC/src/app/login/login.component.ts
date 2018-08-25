import { UserService } from '../services/user.service';
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
  validUser = null;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.validUser = null;
    this.inputUser = {
      uid: 0,
      fname: '',
      lname: '',
      email: null,
      password: '',
      posid:0
    };
  } 

  login() {
    this.loginUser(this.inputUser);
  }

  loginUser(user: User): void {
    console.log('service: loginUser');
    this.httpClient.post<User>('http://localhost:8080/expenseProject/LoginServlet',
          user).subscribe(
          currentUser => {
            console.log('login successful');
            console.dir(currentUser);
            console.log(currentUser.email);
            console.log(currentUser.posid);
            localStorage.setItem('users', JSON.stringify(currentUser));
            this.setUser();
          },
          err => alert('failed login')
        );
        console.log('sent post');
  }

  setUser() {
    this.validUser = JSON.parse(localStorage.getItem('user'));
  }


}