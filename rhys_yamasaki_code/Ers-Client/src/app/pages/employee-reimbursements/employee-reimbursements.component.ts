import { User } from '../../models/user';
import { LoggedInService } from '../../logged-in.service';
import { ReimbursementsListService } from '../../reimbursements-list.service';
import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement';

@Component({
  selector: 'app-employee-reimbursements',
  templateUrl: './employee-reimbursements.component.html',
  styleUrls: ['./employee-reimbursements.component.css']
})
export class EmployeeReimbursementsComponent implements OnInit {

  user: User;
  reimbursement: Reimbursement[];

  constructor(private reim: ReimbursementsListService, private logged: LoggedInService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
    this.getEmployeeReimbursements();
  }

  getEmployeeReimbursements() {
    this.reim.getEmployeePending(this.user.user_id).subscribe(x => this.reimbursement = x);
  }

}
