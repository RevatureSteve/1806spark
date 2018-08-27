import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../../models/reimbursement';
import { ReimbursementListService } from '../../../services/reimbursement-list.service';
import { LoggedUserService } from '../../../services/logged-user.service';
import { User } from '../../../models/user';

@Component({
  selector: 'app-reimbursement-list',
  templateUrl: './reimbursement-list.component.html',
  styleUrls: ['./reimbursement-list.component.css']
})
export class ReimbursementListComponent implements OnInit {
  reimbursements: Reimbursement[] = [];
  user: User;
  filter: number;
  status: string;
  active: string[];
  style: string[] = ['', 'primary', 'success', 'danger'];
  easterEgg = false;
  constructor(private reimbService: ReimbursementListService, private logged: LoggedUserService) { }

  ngOnInit() {
    this.getReimbursements();
    this.filter = 1;
    this.active = ['active', '', ''];
  }

  getReimbursements(): void {
    this.user = this.logged.getLoggedUser();
    this.reimbService.getReimbursementsByUserId(this.user.uId);
    this.reimbService.getReimbursementsArray().subscribe(reimbursements => this.reimbursements = this.sortReimbursements(reimbursements));
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
