import { Reimbursement } from './../models/reimbursement';
import { CurrentUserService } from './../services/current-user.service';
import { ReimbursementService } from './../services/reimbursement.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-approved-reimbursements',
  templateUrl: './employee-approved-reimbursements.component.html',
  styleUrls: ['./employee-approved-reimbursements.component.css']
})
export class EmployeeApprovedReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[] = [];

  constructor(private reimbursementService: ReimbursementService, private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.getApprovedReimbursements();
  }

  getApprovedReimbursements() {
    this.reimbursementService.getApprovedReimbursements()
    .subscribe(reimbursements => {
      reimbursements.forEach(reimbursement => {
        if (this.currentUser.getCurrentUser().userId === reimbursement.empUserId) {
          this.reimbursements.push(reimbursement);
        }
      });
    });
  }
}
