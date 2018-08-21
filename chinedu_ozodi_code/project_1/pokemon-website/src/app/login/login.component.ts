import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../login.service';



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
    this.loginService.login(this.user).subscribe( resp => {
      console.log(resp);
      if (resp.status === 'good') {
        console.log('login good!');
        // redirect to main page
        this.router.navigate(['main']);

      } else {
        console.log('login bad! Try again');
        this.user.password = '';
      }
    });
  }

}
