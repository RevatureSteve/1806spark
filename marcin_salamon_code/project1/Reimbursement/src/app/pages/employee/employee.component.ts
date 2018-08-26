import { Component, OnInit } from '@angular/core';
import { LoggedUserService } from '../../services/logged-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private logged: LoggedUserService, private routes: Router) { }

  ngOnInit() {
    if (!this.logged.getLoggedUser()) {
      this.routes.navigate(['/']);
    }
  }

}
