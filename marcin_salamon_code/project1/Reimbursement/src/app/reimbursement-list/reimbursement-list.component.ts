import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../reimbursement';
import { ReimbursementListService } from '../reimbursement-list.service';
import { LoggedUserService } from '../logged-user.service';
import { User } from '../user';

@Component({
  selector: 'app-reimbursement-list',
  templateUrl: './reimbursement-list.component.html',
  styleUrls: ['./reimbursement-list.component.css']
})
export class ReimbursementListComponent implements OnInit {
  reimbursements: Reimbursement[];
  user: User;
  constructor(private reimbService: ReimbursementListService, private logged: LoggedUserService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedUser();
    // this.reimbService.getPendingReimbursementsById(this.user.uId);
    this.reimbService.getPendingReimbursementsById(1);
    this.getReimbursements();
  }

  getReimbursements(): void {
    this.reimbService.getReimbursementsArray().subscribe(reimbursements => this.reimbursements = this.sortReimbursements(reimbursements));
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
