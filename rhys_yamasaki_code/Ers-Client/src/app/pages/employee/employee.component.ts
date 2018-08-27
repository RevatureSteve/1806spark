import { ReimbursementsListService } from '../../reimbursements-list.service';
import { Reimbursement } from '../../models/reimbursement';
import { ActivatedRoute } from '@angular/router';
import { LoggedInService } from '../../logged-in.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  user: User;
  reimbursement: Reimbursement[];
  pendingReimbursement: Reimbursement[];

  constructor(private httpClient: HttpClient, private logged: LoggedInService, private route: ActivatedRoute,
  private reim: ReimbursementsListService) {
   }

  ngOnInit() {
    this.logged.checkLoggedInUser();
    this.user = this.logged.getLoggedInUser();
    this.getReimbursementsById();
  }

  getReimbursementsById() {
    this.reim.getReimbursementsById(this.user.user_id).subscribe(reim => this.reimbursement = reim);
  }

}
