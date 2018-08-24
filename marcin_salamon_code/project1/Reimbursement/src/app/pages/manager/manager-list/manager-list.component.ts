import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../../models/reimbursement';
import { ReimbursementListService } from '../../../services/reimbursement-list.service';
import { Decision } from '../../../models/decision';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {
  reimbursements: Reimbursement[];
  constructor(private reimbService: ReimbursementListService) { }

  ngOnInit() {
    this.getReimbursements();
  }

  getReimbursements(): void {
    this.reimbService.getAllReimbursements();
    this.reimbService.getReimbursementsArray().subscribe(reimbursements => this.reimbursements = this.sortReimbursements(reimbursements));
  }

  managerDecision(): void {
    this.reimbService.managerDecision(this.reimbursements);
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

