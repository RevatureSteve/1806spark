import { ReimbursementService } from './../../services/reimbursement.service';
import { Reimbursement } from './../../models/reimbursement.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-all-user-reimb',
  templateUrl: './view-all-user-reimb.component.html',
  styleUrls: ['./view-all-user-reimb.component.css']
})
export class ViewAllUserReimbComponent implements OnInit {

  reimbursement: Reimbursement[];
  user = {
    uId: 0,
    email: '',
    password: '',
    firstname: '',
    lastname: '',
    posId: 0
  };

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
  }

  searchUser() {
    this.viewAllReimbursementsById(this.user.uId);
  }

  viewAllReimbursementsById(uId: number) {
    this.reimbursementService.viewAllReimbursementsById(uId)
      .subscribe(resp => this.reimbursement = resp);
  }

}
