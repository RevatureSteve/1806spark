import { ReimbursementsService } from './../reimbursements.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reimbursements } from '../models/reimbursements.model';

@Component({
  selector: 'app-employee-reimbursement',
  templateUrl: './employee-reimbursement.component.html',
  styleUrls: ['./employee-reimbursement.component.css']
})
export class EmployeeReimbursementComponent implements OnInit {

  reimbs: Reimbursements[];

  constructor(private reimbursementsService: ReimbursementsService) { }

  ngOnInit() {
    this.reimbursementsService.getAllReimbursements();
    this.getReimbursements();
  }

  getReimbursements() {
    this.reimbursementsService.getReimbursementsArray()
      .subscribe(reimbursements => this.reimbs = this.viewReimbursements(reimbursements));
  }

  viewReimbursements(reimb): Reimbursements[] {
    console.log(reimb);
    return reimb;
  }


}



