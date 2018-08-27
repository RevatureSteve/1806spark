import { ReimbursementService } from './../services/reimbursement.service';
import { Reimbursement } from './../models/reimbursement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-all-reimbursements',
  templateUrl: './manager-all-reimbursements.component.html',
  styleUrls: ['./manager-all-reimbursements.component.css']
})
export class ManagerAllReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[];

  constructor(private reimburementService: ReimbursementService) { }

  ngOnInit() {
    this.getAllReimbursements();
    }

  getAllReimbursements() {
    this.reimburementService.getAllReimbursements()
      .subscribe(reimbursements => this.reimbursements = reimbursements);
  }

}
