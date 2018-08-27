import { UserService } from './../../services/user.service';
import { User } from './../../models/user.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.user = {
      uId: 0,
      email: '',
      password: '',
      fname: '',
      lname: '',
      posId: 0
    };
  }

  login() {
    this.userService.login(this.user);
  }

}
