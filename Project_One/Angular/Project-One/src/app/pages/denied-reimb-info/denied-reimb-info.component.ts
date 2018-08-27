import { Users } from './../../models/Users';
import { LoggedInService } from './../../logged-in.service';
import { Reimbursement } from './../../models/Reimbursement';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-denied-reimb-info',
  templateUrl: './denied-reimb-info.component.html',
  styleUrls: ['./denied-reimb-info.component.css']
})
export class DeniedReimbInfoComponent implements OnInit {
  postD: Reimbursement[];
  user: Users;

  constructor(private data: DataService, private loggedInService: LoggedInService) { }

  ngOnInit() {
    this.getReimb();
    this.user = this.loggedInService.getLoggedInUser();
  }

  getReimb() {
    this.data.getDeniedReimb().subscribe(
      data => this.postD = data);
  }
}
