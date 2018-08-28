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
  success = true;

  constructor(private userService: UsersService, private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
  }

  login(email, password) {
    this.success = true;
    console.log('email: ' + email + ' password: ' + password);
    this.userService.login(email, password).subscribe(
      user => {
        this.changeCurrentUser(user);
      },
      err => {
        this.success = false;
      }
    );
  }

  changeCurrentUser(user) {
    this.user = user;
    if (user) {
      this.currentUser.setCurrentUser(user);
      if (user.pos_id === 1) {
        this.router.navigate(['home']);
      } else {
        this.router.navigate(['home/sorcerer']);
      }

    } else {
      alert('Login failed: email or password where incorrect');
    }
  }

}
