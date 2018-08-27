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

  user: User;
  reimbursement: Reimbursement[];

  constructor(private userService: UserService, private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.user = this.userService.user;
    console.dir(this.user);
    this.viewReimbursement(1);
  }

  viewReimbursement(uId: number) {
    this.reimbursementService.viewAllPendingReimbursementsById(uId)
    .subscribe((resp: any) => this.reimbursement = resp);
  }

}
