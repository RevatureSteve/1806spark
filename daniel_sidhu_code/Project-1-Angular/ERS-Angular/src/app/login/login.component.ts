import { CurrentUserService } from './../services/current-user.service';
import { UserService } from './../services/user.service';
import { Component, OnInit, NgModule } from '@angular/core';
import { Users } from '../models/users';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  inputUser: Users;

  constructor(private userService: UserService, private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {

  }

  login(email, password) {
    console.log('email: ' + email + ' password ' + password);
    this.userService.login(email, password).subscribe(
      inputUser => this.changePage(inputUser)
    );
  }

  changePage(inputUser) {
    this.inputUser = inputUser;
    if (inputUser) {
      this.currentUser.setCurrentUser(inputUser);
      if (inputUser.positionId === 1) {
        this.router.navigate(['home/manager']);
      } else {
        this.router.navigate(['login']);
      }
    } else {
      this.router.navigate(['login']);
    }
  }
}

