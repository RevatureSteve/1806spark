import { CurrentUserService } from '../../current-user.service';
import { UsersService } from '../../users.service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../../models/users.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: Users;

  constructor(private userService: UsersService, private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
  }

  login(email, password) {
    console.log('email: ' + email + ' password: ' + password);
    this.userService.login(email, password).subscribe(
      user => {
        console.log(user);
        this.changeCurrentUser(user);
      },
      err => {
        // alert('Login failed: email or password were incorrect');
      }
    );
  }

  changeCurrentUser(user) {
    this.user = user;
    if (user) {
      this.currentUser.setCurrentUser(user);
      if (user.pos_id === 1) {
        this.router.navigate(['home']);
      } else {
        this.router.navigate(['home/manager']);
      }

    } else {
      alert('Login failed: email or password where incorrect');
    }
  }

}
