import { ReimbursementService } from './../../services/reimbursement.service';
import { UserService } from './../../services/user.service';
import { User } from './../../models/user.model';
import { Reimbursement } from './../../models/reimbursement.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-reimbursements',
  templateUrl: './view-reimbursements.component.html',
  styleUrls: ['./view-reimbursements.component.css']
})
export class ViewReimbursementsComponent implements OnInit {

  reimbursement: Reimbursement[];

  constructor(private userService: UserService, private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.viewReimbursement(this.userService.currentUser().uId);
  }

  viewReimbursement(uId: number) {
    this.reimbursementService.viewAllPendingReimbursementsById(uId)
    .subscribe(resp => this.reimbursement = resp);
  }

}
