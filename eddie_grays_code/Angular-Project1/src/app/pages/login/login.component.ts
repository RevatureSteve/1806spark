import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.user = {
      uId: 0,
      email: '',
      password: '',
      firstname: '',
      lastname: '',
      posId: 0
    };
  }

  login() {
    this.userService.validateUser(this.user);
  }

}
