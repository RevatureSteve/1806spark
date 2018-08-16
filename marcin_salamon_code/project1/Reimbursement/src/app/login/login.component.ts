import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    document.getElementById('loginBtn').onclick=this.validateUser;
  }

  validateUser(): void{
    // let email = document.getElementById('email');
    // let password = document.getElementById('password');

    this.user = this.loginService.validateUser('a@a.com', '123').subscribe(user=>this.user = user);
  }

}
