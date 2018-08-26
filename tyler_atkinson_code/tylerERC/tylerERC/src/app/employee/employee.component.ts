import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { LoggedUserService } from '../services/logged-user.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  user: User;
  constructor(private logged: LoggedUserService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedUser();
    console.log(this.user);
  }

}
