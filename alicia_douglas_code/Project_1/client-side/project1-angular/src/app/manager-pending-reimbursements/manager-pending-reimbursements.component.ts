import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ReimbursementsService } from '../reimbursements.service';
import { Reimbursements } from '../models/reimbursements.model';
import { CurrentUserService } from '../current-user.service';
import { Users } from '../models/users.model';

@Component({
  selector: 'app-manager-pending-reimbursements',
  templateUrl: './manager-pending-reimbursements.component.html',
  styleUrls: ['./manager-pending-reimbursements.component.css']
})
export class ManagerPendingReimbursementsComponent implements OnInit {

  user: Users;
  reimb: Reimbursements;
  reimbs: Reimbursements[];
  allReimbs: Reimbursements[];
  sortedReimbs: Reimbursements[];

  constructor(private reimbService: ReimbursementsService, private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    this.getPendingReimbursements();
  }

  getPendingReimbursements() {
    console.log('Get pending reimbursements');
    this.reimbService.getPendingReimbursements()
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

  approve(rId, r) {
    console.log(r);
    console.log(`approve clicked rId: ${rId}`);
    this.reimbService.updateReimbursement(rId, this.user.u_id, 2)
      .subscribe(reimb => this.reimb = reimb);
    this.removeResolved(rId);
  }

  deny(rId, r) {
    console.log(`deny clicked rId: ${rId}`);
    this.reimbService.updateReimbursement(rId, this.user.u_id, 3)
      .subscribe(reimb => this.reimb = reimb);
    this.getPendingReimbursements();
    this.removeResolved(rId);
  }

  removeResolved(Id) {
    for (let i = 0; i < this.reimbs.length; i++) {
      if (this.reimbs[i].rId === Id) {
        console.log('Should remove value');
        this.reimbs.splice(i, 1);
        console.log(this.reimbs);
      }
    }
  }

}
