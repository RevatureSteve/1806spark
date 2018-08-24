import { CurrentUserService } from './../current-user.service';
import { LoginService } from './../login.service';
import { User } from './../user';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { RouterModule, ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;

  constructor(private login: LoginService, private logged: CurrentUserService, private route: ActivatedRoute, private router: Router) { }


  getUser(email, password): void {
    this.login.getUser(email, password).subscribe(user => this.changePage(user));
  }

  changePage(user) {
    this.makeCurrentUser(user);
    this.logged.getCurrentUser();
    this.router.navigate(['/', this.user.pos_id, 'home']);
  }

  makeCurrentUser(user) {
    this.user = user;
    this.logged.setCurrentUser(this.user);
  }

  ngOnInit() {
  }
}
