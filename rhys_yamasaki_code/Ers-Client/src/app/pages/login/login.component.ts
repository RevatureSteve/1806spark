import { LoggedInService } from '../../logged-in.service';
import { LoginService } from '../../login.service';
import { User } from '../../models/user';
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

  constructor(private login: LoginService, private logged: LoggedInService, private route: ActivatedRoute, private router: Router) { }


  getUser(email, password): void {
    this.login.getUser(email, password).subscribe(user => this.changePage(user)
  );
  }

  changePage(user) {
    this.changeLoggedInUser(user);
    this.logged.getLoggedInUser();
    localStorage.setItem('user', JSON.stringify(user));
    console.log(localStorage.getItem('user'));
    this.router.navigate(['/', this.user.pos_name, 'home']);
  }

  changeLoggedInUser(user) {
    this.user = user;
    this.logged.setLoggedInUser(this.user);
  }

  ngOnInit() {
  }

}
