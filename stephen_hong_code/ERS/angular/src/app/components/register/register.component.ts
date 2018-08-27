import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message = '';
  user = new User();
  users: User[] = [];
  isValid = false;
  loggedUser = localStorage.getItem('user');
  role = false;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    if(this.loggedUser != null){
      this.router.navigate(['landing']);
    }
    this.user.pwSalt = '';
    this.user.role = 1;
    this.loadUsers();
  }

  loadUsers() {
    this.users = [];
    this.userService.getAllUsers().subscribe(u => {
      this.users = u;
    });
  }

  register() {
    if (this.role) {
      this.user.role = 2;
    }
    this.userService.registerUser(this.user).subscribe(u => {
      if (u.id === -1) {
        this.isValid = false;
      } else {
        this.userService.subscribers.next(u);
        localStorage.setItem('user', JSON.stringify(u));
        // console.log(`User, ${this.user.username}, successfully registered`);
        this.router.navigate(['landing']);
      }
    });
  }

  validate() {
    console.log('Validating');
    this.message = '';
    this.isValid = true;

    if (!this.user.firstName || !this.user.lastName || !this.user.email || !this.user.username || !this.user.pwHash) {
      this.message = 'Required fields are empty';
      this.isValid = false;
    } else {
      if (this.user.username.length > 50) {
        this.message = 'Username must be 50 characters or less';
        this.isValid = false;
      }
      if (this.user.firstName.length > 100) {
        this.message = 'First name must be 100 characters or less';
        this.isValid = false;
      }
      if (this.user.lastName.length > 100) {
        this.message = 'Last name must be 100 characters or less';
        this.isValid = false;
      }
      if (this.user.email.length > 150) {
        this.message = 'Email address must be 100 characters or less';
        this.isValid = false;
      }
      if (this.user.pwHash.length > 50) {
        this.message = 'Password must be 100 characters or less';
        this.isValid = false;
      }
    }

    this.validateUsername();
    this.validateEmail();
  }

  validateUsername() {
    const sameName = this.users.filter(u => {
      return u.username === this.user.username;
    });

    if (sameName.length) {
      this.message = 'A user with that username already exists';
      this.isValid = false;
    }
  }

  validateEmail() {
    const sameEmail = this.users.filter(u => {
      return u.email === this.user.email;
    });

    let regex = RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
    if (sameEmail.length) {
      this.message = 'A user with that email address already exists';
      this.isValid = false;
    } else if (!regex.test(this.user.email)){
      this.message = 'A valid email address is required';
      this.isValid = false;
    }
  }
}
