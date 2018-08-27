import { LoggedInService } from './../../logged-in.service';
import { Users } from './../../models/Users';
import { Reimbursement } from './../../models/Reimbursement';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-approved-reimb-info',
  templateUrl: './approved-reimb-info.component.html',
  styleUrls: ['./approved-reimb-info.component.css']
})
export class ApprovedReimbInfoComponent implements OnInit {
  postA: Reimbursement[];
  user: Users;

  constructor(private data: DataService, private loggedInService: LoggedInService) { }

  ngOnInit() {
    this.getReimb();
    this.user = this.loggedInService.getLoggedInUser();
  }

  getReimb() {
    this.data.getApprovedReimb().subscribe(
      data => this.postA = data);
  }

}
