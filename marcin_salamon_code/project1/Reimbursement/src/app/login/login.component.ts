import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';
import { LoggedUserService } from '../logged-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;

  constructor(private login: LoginService, private logged: LoggedUserService) { }

  ngOnInit() {
  }

  validateUser(email, psw): void {
    this.login.validateUser(email, psw).subscribe(user => this.changePage(user));
  }

  changePage(user) {
    this.changeLogged(user);
    // changes the page depending on user position
  }

  changeLogged(user) {
    this.user = user;
    this.logged.setLoggedUser(user);
  }

}
