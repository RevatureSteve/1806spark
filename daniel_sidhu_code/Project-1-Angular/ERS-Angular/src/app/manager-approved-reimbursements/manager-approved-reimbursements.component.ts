import { ReimbursementService } from './../services/reimbursement.service';
import { Reimbursement } from './../models/reimbursement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-approved-reimbursements',
  templateUrl: './manager-approved-reimbursements.component.html',
  styleUrls: ['./manager-approved-reimbursements.component.css']
})
export class ManagerApprovedReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[];

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.getApprovedReimbursements();
  }

  getApprovedReimbursements() {
    this.reimbursementService.getApprovedReimbursements()
      .subscribe(reimbursements => this.reimbursements = reimbursements);
  }
}
