import { Users } from './../../models/Users';
import { Reimbursement } from './../../models/Reimbursement';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';
import { LoggedInService } from './../../logged-in.service';

@Component({
  selector: 'app-pending-reimb-info',
  templateUrl: './pending-reimb-info.component.html',
  styleUrls: ['./pending-reimb-info.component.css']
})
export class PendingReimbInfoComponent implements OnInit {
  postP: Reimbursement[];
  user: Users;

  constructor(private data: DataService, private loggedInService: LoggedInService) { }

  ngOnInit() {
    this.getReimb();
    this.user = this.loggedInService.getLoggedInUser();
  }

  getReimb() {
    this.data.getPendReimb().subscribe(
      data => this.postP = data);
  }
}
