
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

  constructor(private reimbService: ReimbursementsService, private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    this.getPendingReimbursements();
  }

  getPendingReimbursements() {
    console.log('Get pending reimbursements');
    this.reimbService.getPendingReimbursements()
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

  approve(r) {
    console.log(`approve clicked rId: ${r}`);
    this.reimbService.updateReimbursement(r.rId, this.user.u_id, 2, r.empUId)
      .subscribe(reimb => this.reimb = reimb);
    this.removeResolved(r.rId);
  }

  deny(r) {
    console.log(`deny clicked rId: ${r}`);
    this.reimbService.updateReimbursement(r.rId, this.user.u_id, 3, r.empUId)
      .subscribe(reimb => this.reimb = reimb);
    this.removeResolved(r.rId);
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
