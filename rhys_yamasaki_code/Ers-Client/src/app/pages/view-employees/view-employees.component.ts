import { Reimbursement } from './../../models/reimbursement';
import { ReimbursementsListService } from './../../reimbursements-list.service';
import { LoggedInService } from './../../logged-in.service';
import { EmployeeListService } from './../../employee-list.service';
import { User } from './../../models/user';
import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-view-employees',
  templateUrl: './view-employees.component.html',
  styleUrls: ['./view-employees.component.css']
})
export class ViewEmployeesComponent implements OnInit {

  user: User[];
  reimbursement: Reimbursement[];
  currUser: User;

  constructor(private emp: EmployeeListService, private logged: LoggedInService, private reim: ReimbursementsListService,
  private router: Router) { }

  ngOnInit() {
    this.currUser = this.logged.getLoggedInUser();
    this.getAllUsers();
  }

  getAllUsers() {
    this.emp.getAllUsers().subscribe(user => this.user = user);
  }

  getReimbursementsById(id) {

    // this.reim.getReimbursementsById(id).subscribe(rb => this.reimbursement = rb);
    this.router.navigate([`/managers/employees/${id}`]);
  }
}
