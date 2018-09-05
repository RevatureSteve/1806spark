import { UsersService } from './../users.service';
import { CurrentUserService } from './../current-user.service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users.model';

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrls: ['./new-employee.component.css']
})
export class NewEmployeeComponent implements OnInit {

  user: Users;

  constructor(private currentUser: CurrentUserService, private userService: UsersService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
  }

  createNewUser(email, fname, lname, pos) {
    const user = {
      email: email,
      fname: fname,
      lname: lname,
      password: '111',
      pos_id: pos
    };
    this.userService.createUser(user).subscribe(u => alert('new user made'));
  }

}