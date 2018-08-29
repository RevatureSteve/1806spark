import { Component, OnInit } from '@angular/core';
import { ReimbursementsService } from '../reimbursements.service';
import { CurrentUserService } from '../current-user.service';
import { Reimbursements } from '../models/reimbursements.model';

@Component({
  selector: 'app-emp-pending-reimbursements',
  templateUrl: './emp-pending-reimbursements.component.html',
  styleUrls: ['./emp-pending-reimbursements.component.css']
})
export class EmpPendingReimbursementsComponent implements OnInit {

  user;

  reimbs: Reimbursements[];

  constructor(private reimbursementsService: ReimbursementsService, private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    // console.log(this.user);
    this.getEmployeePending();
  }

  getEmployeePending() {
    // const id = 1; // hard coed for now , change back later
    const id = this.user.u_id;
    this.reimbursementsService.getPendingReimbursemetsById(id)
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

}
