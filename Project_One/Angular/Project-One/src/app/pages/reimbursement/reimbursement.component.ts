import { LoggedInService } from './../../logged-in.service';
import { Users } from './../../models/Users';
import { Reimbursement } from './../../models/Reimbursement';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {
  postR: Reimbursement[];
  user: Users;

  constructor(private data: DataService, private loggedInService: LoggedInService) { }

  ngOnInit() {
    this.getReimb();
    this.user = this.loggedInService.getLoggedInUser();
    console.log(this.user);
  }

  getReimb() {
    this.data.getReimbs().subscribe(
      data => this.postR = data);
  }
}
