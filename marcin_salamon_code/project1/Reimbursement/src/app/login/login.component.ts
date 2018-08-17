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
    this.login.validateUser(email, psw).subscribe(user => this.user = user);
  }

  changeLogged() {
    this.logged.setLoggedUser(this.user);
  }

}
