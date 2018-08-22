import { LoggedInService } from '../logged-in.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-employee-navbar',
  templateUrl: './employee-navbar.component.html',
  styleUrls: ['./employee-navbar.component.css']
})
export class EmployeeNavbarComponent implements OnInit {

  user: User;

  constructor(private logged: LoggedInService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
  }

}
