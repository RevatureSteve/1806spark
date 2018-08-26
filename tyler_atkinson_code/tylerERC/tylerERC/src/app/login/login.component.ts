import { LoggedUserService } from '../services/logged-user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputUser: User;
  validUser = null;
  user: User;

  constructor(private httpClient: HttpClient, private logged: LoggedUserService, private routes: Router) { }

  ngOnInit() {
    this.validUser = null;
    this.inputUser = {
      uid: 0,
      fname: '',
      lname: '',
      email: null,
      password: '',
      posid: 0
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

          this.changeLogged(currentUser)

          if (currentUser.posid === 1) {
            this.routes.navigate(['Employee']);
          } else if (currentUser.posid === 2) {
            this.routes.navigate(['Manager']);
          }

        },
        err => alert('failed login')
      );
    console.log('sent post');
  }

changeLogged(user) {
  this.user = user;
  this.logged.setLoggedUser(user);
}


}



