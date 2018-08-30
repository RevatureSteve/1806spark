import { async } from '@angular/core/testing';
import { LoginService } from '../../login.service';
import { Router } from '@angular/router';
import { UpdateEmployeeService } from '../../update-employee.service';
import { User } from '../../models/user';
import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { LoggedInService } from '../../logged-in.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  user: User;
  editable = false;
  subscription: Object = null;
  loadUser: User;

  constructor(private logged: LoggedInService, private update: UpdateEmployeeService,
    private router: Router, private login: LoginService, private changes: ChangeDetectorRef) { }

  ngOnInit() {
    this.loadUser = this.logged.getLoggedInUser();
    this.login.getUser(this.loadUser.email, this.loadUser.password).subscribe(x => this.user = x);
  }

  editFields() {
    this.editable = !this.editable;
  }

  editUserInfo(email, userId, password, fname, lname) {
    this.update.updateEmployeeInfo(userId, password, fname, lname).subscribe(x => {});
    this.login.getUser(email, password).subscribe(x => this.user = x);
    this.router.navigateByUrl('/easteregg', {skipLocationChange: false}).then(() =>
    this.router.navigate(['/employee/home']));
  }

}
