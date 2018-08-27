import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../../models/reimbursement';
import { ReimbursementListService } from '../../../services/reimbursement-list.service';
import { Decision } from '../../../models/decision';
import { DecisionsService } from '../../../services/decisions.service';
import { LoggedUserService } from '../../../services/logged-user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {
  reimbursements: Reimbursement[] = [];
  decisions: Decision[];
  filter: number;
  active: string[];
  style: string[] = ['', 'primary', 'success', 'danger'];
  easterEgg = false;
  constructor(private reimbService: ReimbursementListService, private decisionService: DecisionsService,
    private logged: LoggedUserService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getReimbursements();
    this.filter = 1;
    this.active = ['active', '', ''];
  }

  getReimbursements(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    if (id) {
      this.getReimbursementsByUserId(id);
    } else {
      this.reimbService.getAllReimbursements();
      this.reimbService.getReimbursementsArray().subscribe(reimbursements => this.reimbursements = this.sortReimbursements(reimbursements));
    }

  }

  setPending() {
    this.filter = 1;
    this.active = ['active', '', ''];
  }

  setResolved() {
    this.filter = 2;
    this.active = ['', 'active', ''];
  }

  setDenied() {
    this.filter = 3;
    this.active = ['', '', 'active'];
  }

  getReimbursementsByUserId(id) {
    this.reimbService.getAllReimbursements();
    this.reimbService.getReimbursementsArray().subscribe(reimbursements => {
      reimbursements.forEach(reimb => {
        if (reimb.employee.uId === id) {
          this.reimbursements.push(reimb);
        }
      });
      this.reimbursements = this.sortReimbursements(this.reimbursements);

    });
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
    if (reimb.length === 0) {
      this.easterEgg = true;
    } else {
      this.easterEgg = false;
    }
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

