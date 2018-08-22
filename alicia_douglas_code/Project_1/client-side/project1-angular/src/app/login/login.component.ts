import { CurrentUserService } from './../current-user.service';
import { UsersService } from './../users.service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: Users;
  // curUser: Users;

  constructor(private userService: UsersService, private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
  }

  login(email, password) {
    // const email = document.getElementById('email').value;
    // const password = document.getElementById('password').value;
    console.log('email: ' + email + ' password: ' + password);
    this.userService.getUser(email, password).subscribe(
      user => this.changeCurrentUser(user)
    );
  }

  changeCurrentUser(user) {
    this.user = user;
    // this.user = {
    //   u_id: user.u_id,
    //   email: user.email,
    //   password: user.password,
    //   fname: user.fname,
    //   lname: user.lname,
    //   pos_id: user.pos_id,
    //   posTitle: user.posTitle
    // };
    // console.log(user);
    // console.log(user);
    if (user) {
      this.currentUser.setCurrentUser(user);
      if (user.pos_id === 1) {
        this.router.navigate(['home']);
      } else {
        this.router.navigate(['home/sorcerer']);
      }

    } else {
      // later add something telling user login failed
      this.router.navigate(['login']);
    }
  }

}
