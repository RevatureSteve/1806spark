import { CurrentUserService } from './../current-user.service';
import { ReimbursementsService } from './../reimbursements.service';
import { Component, OnInit } from '@angular/core';
import { Reimbursements } from '../models/reimbursements.model';

@Component({
  selector: 'app-employee-reimbursement',
  templateUrl: './employee-reimbursement.component.html',
  styleUrls: ['./employee-reimbursement.component.css']
})
export class EmployeeReimbursementComponent implements OnInit {

  user;

  reimbs: Reimbursements[];

  constructor(private reimbursementsService: ReimbursementsService, private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    this.getEmployeeReimbursements();
  }

  getEmployeeReimbursements() {
    const id = this.user.u_id;
    this.reimbursementsService.getReimbursementById(id)
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }



}



