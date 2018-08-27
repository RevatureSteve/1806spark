import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { User } from '../../models/user';
import { LoginService } from '../../services/login.service';
import { LoggedUserService } from '../../services/logged-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  failed: boolean;
  constructor(private login: LoginService, private logged: LoggedUserService, private routes: Router) { }

  ngOnInit() {
  }

  validateUser(email, psw): void {
    console.log('validate');
    this.login.validateUser(email, psw).subscribe(user => this.changePage(user));
  }

  changePage(user) {
    this.changeLogged(user);
    if (!this.user) {
      this.failed = true;
    } else if (this.user.positionId === 1) {
      this.routes.navigate(['employee']);
    } else if (this.user.positionId === 2) {
      this.routes.navigate(['manager']);
    }
    // changes the page depending on user position
  }

  changeLogged(user) {
    this.user = user;
    this.logged.setLoggedUser(user);
  }

  clearFailed() {
    this.failed = false;
  }

}
