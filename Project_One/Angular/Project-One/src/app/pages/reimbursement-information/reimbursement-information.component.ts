import { Users } from './../../models/Users';
import { DataService } from './../../data.service';
import { Reimbursement } from './../../models/Reimbursement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reimbursement-information',
  templateUrl: './reimbursement-information.component.html',
  styleUrls: ['./reimbursement-information.component.css']
})
export class ReimbursementInformationComponent implements OnInit {
  postAll: Reimbursement[];
  user: Users;
  managerId: Reimbursement;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getReimb();
    // Setting the userId to a manager ID if the user is a manager
    if (this.user.pos_Id === 1) {
      this.user.u_Id = this.managerId.mgr_U_Id;
    }
   }

  getReimb() {
    this.data.getReimbs().subscribe(
      data => this.postAll = data);
  }
}
