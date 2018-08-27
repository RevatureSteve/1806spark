import { Users } from './../models/users';
import { UserService } from './../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-view-employees',
  templateUrl: './manager-view-employees.component.html',
  styleUrls: ['./manager-view-employees.component.css']
})
export class ManagerViewEmployeesComponent implements OnInit {

  // create users object array
  users: Users[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getAllEmployees();
  }

  // here I get all employees and show on the components HTML page
  getAllEmployees() {
    this.userService.getAllEmployees()
      .subscribe(users => this.users = users);
  }
}
