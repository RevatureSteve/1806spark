import { UpdateReimbService } from './../../update-reimb.service';
import { LoggedInService } from './../../logged-in.service';
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
  username: Users[];
  // To access mgr_U_Id;
  managerId: Reimbursement;

  constructor(private data: DataService, private loggedInService: LoggedInService,
    private updateReimb: UpdateReimbService) { }

  ngOnInit() {
    this.getReimb();
    this.getUsers();
    // Setting the userId to a manager ID if the user is a manager
    this.user = this.loggedInService.getLoggedInUser();

  }
  getUsers() {
    this.data.getUsers().subscribe(
      data => this.username = data);

  }

  getReimb() {
    this.data.getReimbs().subscribe(
      data => this.postAll = data);
  }

  updatingReimb(r_Id, mgr_U_Id, rq_Status_Id): void {
    console.log('service: updatingReimb');
    this.updateReimb.updateReimb(r_Id, mgr_U_Id, rq_Status_Id).subscribe(
      update => {
        console.log('updating your information');
        this.getReimb();
      }
    );
  }
}
