import { CurrentUserService } from './../current-user.service';
import { UsersService } from './../users.service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: Users;

  constructor(private userService: UsersService, private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
  }

  login(email, password) {
    // const email = document.getElementById('email').value;
    // const password = document.getElementById('password').value;
    console.log('email: ' + email + ' password: ' + password);
    this.userService.getUser(email, password).subscribe(
      user => this.changeCurrentUser(user)
    );
  }

  changeCurrentUser(user) {
    this.user = user;
    console.log(user);
    if (user) {
      this.currentUser.setCurrentUser(user);
      this.router.navigate(['profile']);
    } else {
      // later add something telling user login failed
      this.router.navigate(['login']);
    }
  }

}
