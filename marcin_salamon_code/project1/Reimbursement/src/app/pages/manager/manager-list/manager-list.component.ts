import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../../models/reimbursement';
import { ReimbursementListService } from '../../../services/reimbursement-list.service';
import { Decision } from '../../../models/decision';
import { DecisionsService } from '../../../services/decisions.service';
import { LoggedUserService } from '../../../services/logged-user.service';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {
  reimbursements: Reimbursement[];
  decisions: Decision[];
  constructor(private reimbService: ReimbursementListService, private decisionService: DecisionsService,
    private logged: LoggedUserService) { }

  ngOnInit() {
    this.getReimbursements();
  }

  getReimbursements(): void {
    this.reimbService.getAllReimbursements();
    this.reimbService.getReimbursementsArray().subscribe(reimbursements => this.reimbursements = this.sortReimbursements(reimbursements));
  }

// return 1 when adding new decision
// return 2 when updating old decision
  approve(id): number {
    let decision = new Decision();
    decision = {
      rId: id,
      rq_statusId: 2,
      mgrId: this.logged.getLoggedUser().uId
    };
    return this.decisionService.addDecisions(decision);
  }

  deny(id): number {
    let decision = new Decision();
    decision = {
      rId: id,
      rq_statusId: 3,
      mgrId: this.logged.getLoggedUser().uId
    };
    return this.decisionService.addDecisions(decision);
  }

  sortReimbursements(reimb): Reimbursement[] {
    reimb.sort(this.dynamicSort('-timesubmission'));
    console.log(reimb);
    return reimb;
  }

  dynamicSort(property) {
    let sortOrder = 1;
    if (property[0] === '-') {
      sortOrder = -1;
      property = property.substr(1);
    }
    return function (a, b) {
      const result = (a[property] < b[property]) ? -1 : (a[property] > b[property]) ? 1 : 0;
      return result * sortOrder;
    };
  }
}

