import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { LoginService } from '../services/login.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  passwordPlaceholder = 'Password';
  user = new User();

  constructor(
    private loginService: LoginService,
    public router: Router
  ) { console.log('login component started'); }

  ngOnInit() {
  }

  login() {
    console.log('Login -login attempt for ' + this.user.email);
    this.loginService.login(this.user).subscribe( user => {
      console.log(user);
      if (user) {
        this.loginService.currentUser = user;
        this.loginService.getTrainer();
        this.router.navigate(['main']);
        this.loginService.saveUserCookie(user);
      } else {
        console.log('login bad! Try again');
        this.user.password = '';
      }
    });
  }

}
