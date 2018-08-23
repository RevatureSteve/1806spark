import { Component, OnInit } from '@angular/core';
import { ReimbursementsService } from '../reimbursements.service';
import { Reimbursements } from '../models/reimbursements.model';
import { CurrentUserService } from '../current-user.service';
import { Users } from '../models/users.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager-pending-reimbursements',
  templateUrl: './manager-pending-reimbursements.component.html',
  styleUrls: ['./manager-pending-reimbursements.component.css']
})
export class ManagerPendingReimbursementsComponent implements OnInit {

  user: Users;
  reimb: Reimbursements;
  reimbs: Reimbursements[];

  constructor(private reimbService: ReimbursementsService, private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    this.getPendingReimbursements();
  }

  getPendingReimbursements() {
    this.reimbService.getPendingReimbursements()
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

  approve(rId) {
    console.log(`approve clicked rId: ${rId}`);
    this.reimbService.updateReimbursement(rId, this.user.u_id, 2)
      .subscribe(reimb => this.reimb = reimb);
    // console.log(this.reimb);
    this.router.navigate(['home/sorcerer']);
  }

  deny(rId) {
    console.log(`deny clicked rId: ${rId}`);
    this.reimbService.updateReimbursement(rId, this.user.u_id, 3)
      .subscribe(reimb => this.reimb = reimb);
    // console.log(this.reimb);
    this.router.navigate(['home/sorcerer']);
  }

}
