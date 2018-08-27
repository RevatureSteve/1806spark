import { CurrentUserService } from './../services/current-user.service';
import { ReimbursementService } from './../services/reimbursement.service';
import { Users } from './../models/users';
import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../models/reimbursement';

@Component({
  selector: 'app-employee-pending-reimbursements',
  templateUrl: './employee-pending-reimbursements.component.html',
  styleUrls: ['./employee-pending-reimbursements.component.css']
})
export class EmployeePendingReimbursementsComponent implements OnInit {

  user: Users;

  reimbursement: Reimbursement;

  constructor(private reimbursementService: ReimbursementService, private currentUserService: CurrentUserService) { }

  ngOnInit() {
   // this.user = this.currentUser.getCurrentUser();
    this.getEmployeeReimbursements();
  }

  getEmployeeReimbursements() {
   // const id = this.user.getEmployeeReimbursements(this.user.userId).sub
  }
}
