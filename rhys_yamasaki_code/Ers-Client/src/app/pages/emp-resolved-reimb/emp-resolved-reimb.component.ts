import { LoggedInService } from '../../logged-in.service';
import { ReimbursementsListService } from '../../reimbursements-list.service';
import { Reimbursement } from '../../models/reimbursement';
import { User } from '../../models/user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-emp-resolved-reimb',
  templateUrl: './emp-resolved-reimb.component.html',
  styleUrls: ['./emp-resolved-reimb.component.css']
})
export class EmpResolvedReimbComponent implements OnInit {

  user: User;
  reimbursement: Reimbursement[];

  constructor(private reimb: ReimbursementsListService, private logged: LoggedInService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
    this.getResolvedReimbursements(this.user.user_id);
  }

  getResolvedReimbursements(id) {
    this.reimb.getEmployeeResolved(id).subscribe(x => this.reimbursement = x);
  }

}
