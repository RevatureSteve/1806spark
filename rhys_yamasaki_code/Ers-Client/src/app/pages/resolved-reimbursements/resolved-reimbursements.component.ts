import { LoggedInService } from '../../logged-in.service';
import { ReimbursementsListService } from '../../reimbursements-list.service';
import { Reimbursement } from '../../models/reimbursement';
import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';

@Component({
  selector: 'app-resolved-reimbursements',
  templateUrl: './resolved-reimbursements.component.html',
  styleUrls: ['./resolved-reimbursements.component.css']
})
export class ResolvedReimbursementsComponent implements OnInit {
  user: User;
  reimbursement: Reimbursement[];

  constructor(private reim: ReimbursementsListService, private logged: LoggedInService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
    this.getResolvedReimburse();
  }

  getResolvedReimburse() {
    this.reim.getResolvedReimbursements().subscribe(rb => this.reimbursement = rb);
  }

}
