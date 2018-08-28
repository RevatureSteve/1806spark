import { ReimbursementService } from './../services/reimbursement.service';
import { Reimbursement } from './../models/reimbursement';
import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-employee-pending-reimbursements',
  templateUrl: './employee-pending-reimbursements.component.html',
  styleUrls: ['./employee-pending-reimbursements.component.css']
})
export class EmployeePendingReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[] = [];

  constructor(private reimbursementService: ReimbursementService, private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.getPendingReimbursements();
  }

  getPendingReimbursements() {
    this.reimbursementService.getPendingReimbursements()
      .subscribe(reimbursements => {
        reimbursements.forEach(reimbursement => {
          if (this.currentUser.getCurrentUser().userId === reimbursement.empUserId) {
            this.reimbursements.push(reimbursement);
          }
        });
      });
  }

}
