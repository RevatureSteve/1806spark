import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  users: User[] = [];
  user: User;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.loadUsers();
  }

  loadUsers() {
    this.users = [];
    this.userService.getAllUsers().subscribe(u => {
      this.users = u;
    });
  }

  getfName(user: User) {
    const id = this.users.filter(u => {
      return u.id === user.id;
    })[0];
    return `${id.firstName}`;
  }

  getlName(user: User) {
    const id = this.users.filter(u => {
      return u.id === user.id;
    })[0];
    return `${id.lastName}`;
  }

  getUsername(user: User) {
    const id = this.users.filter(u => {
      return u.id === user.id;
    })[0];
    return `${id.username}`;
  }

  getEmail(user: User) {
    const id = this.users.filter(u => {
      return u.id === user.id;
    })[0];
    return `${id.email}`;
  }

  getRole(user: User) {
    const id = this.users.filter(u => {
      return u.id === user.id;
    })[0];
    let x = `${id.role}`;
    if(x == "2"){
      return "Manager"
    } else {
      return "Employee"
    }
  }

}
