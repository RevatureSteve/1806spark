import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { User } from '../../models/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  message = '';
  loggedUser = localStorage.getItem('user');
  isValid = true;
  usr: string;
  pw: string;
  closeResult: string;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit() {
    if(this.loggedUser != null){
      this.router.navigate(['landing']);
    }
  }

  login() {
    this.isValid = true;
    this.userService.loginUser([this.usr, this.pw]).subscribe(user => {
      if (user == null || user.id === -1) {
        this.isValid = false;
      } else {
        this.userService.subscribers.next(user);
        localStorage.setItem('user', JSON.stringify(user));
        this.router.navigate(['landing']);
      }
    });
  }

  register(){
    this.router.navigate(['register']);
  }

}
