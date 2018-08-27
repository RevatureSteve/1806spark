import { ReimbursementService } from './../services/reimbursement.service';
import { Reimbursement } from './../models/reimbursement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-pending-reimbursements',
  templateUrl: './manager-pending-reimbursements.component.html',
  styleUrls: ['./manager-pending-reimbursements.component.css']
})
export class ManagerPendingReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[];

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.getPendingReimbursements();
  }

  getPendingReimbursements() {
    this.reimbursementService.getPendingReimbursements()
      .subscribe(reimbursements => this.reimbursements = reimbursements);
  }

}
