import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { Users } from '../models/users.model';
import { Observable } from 'rxjs';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  users: Users[];

  constructor(private userService: UsersService, private router: Router) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers() {
    this.userService.getAllUsers()
      .subscribe(users => this.users = users);
  }

  employeeSort(uId) {
    this.router.navigate(['employee/' + uId]);
  }

}
