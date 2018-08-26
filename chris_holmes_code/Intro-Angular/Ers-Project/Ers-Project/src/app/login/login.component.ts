import { LoggeduserService } from './../services/loggeduser.service';
import { routes } from './../app-routing.module';
import { HttpClient } from '@angular/common/http';
import { User } from './../models/users';
import { Component, OnInit } from '@angular/core';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  inputUser: User;
  validUser: User;
  constructor(private httpClient: HttpClient, private route: Router) { }

  ngOnInit() {
    this.inputUser = {
      uId: 0,
      email: '',
      password: '',
      fname: '',
      lname: '',
      posId: 0
    };
}

login() {
  console.log(this.inputUser);
  this.loginUser(this.inputUser);

}

loginUser(user: User) {
this.httpClient.post('http://localhost:8080/ErsProject/login', user).subscribe
  (succ => this.changePage(succ), err => console.log('login failed')
);
console.log('welcome back');
console.log(this.validUser);
}

changePage(user) {
  this.validUser = user;
  LoggeduserService.setloggeduser(this.validUser);
  console.log(this.validUser);
  // this.validUser(this.validUser);
  if (!this.validUser) {
    console.log('nope');
  } else if (this.validUser.posId === 1) {
    this.route.navigate(['employee-homepage']);
  }
}

}

