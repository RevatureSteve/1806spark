import { Component, OnInit } from '@angular/core';
import { ReimbursementsService } from '../reimbursements.service';
import { CurrentUserService } from '../current-user.service';
import { Reimbursements } from '../models/reimbursements.model';
import { Users } from '../models/users.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-single-employee-view',
  templateUrl: './single-employee-view.component.html',
  styleUrls: ['./single-employee-view.component.css']
})
export class SingleEmployeeViewComponent implements OnInit {

  user: Users;
  reimb: Reimbursements;
  reimbs: Reimbursements[];
  empId;

  constructor(private reimbService: ReimbursementsService, private currentUser: CurrentUserService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    this.empId = +this.route.snapshot.paramMap.get('id');
    console.log(this.empId);
    this.getEmployeeReimbursements();
  }

  getEmployeeReimbursements() {
    this.reimbService.getReimbursementById(this.empId)
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

  approve(rId) {
    console.log(`approve clicked rId: ${rId}`);
    this.reimbService.updateReimbursement(rId, this.user.u_id, 2)
      .subscribe(reimb => this.reimb = reimb);
    this.changeStatus(rId, 'Approved');
  }

  deny(rId) {
    console.log(`deny clicked rId: ${rId}`);
    this.reimbService.updateReimbursement(rId, this.user.u_id, 3)
      .subscribe(reimb => this.reimb = reimb);
    this.changeStatus(rId, 'Denied');
  }

  changeStatus(Id, status) {
    for (let i = 0; i < this.reimbs.length; i++) {
      if (this.reimbs[i].rId === Id) {
        console.log('Should change status');
        this.reimbs[i].rbStatus = status;
        this.reimbs[i].managerName = this.user.fname + ' ' + this.user.lname;
        console.log(this.reimbs);
      }
    }
  }

}
