import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';
import { Router } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-manager-reimbursement',
  templateUrl: './manager-reimbursement.component.html',
  styleUrls: ['./manager-reimbursement.component.css']
})
export class ManagerReimbursementComponent implements OnInit {

  reimbs: Reimbursement[] = [];
  holdReimbs: Reimbursement[] = [];
  users: User[] = [];
  user: User;
  statuses = ['', 'Pending', 'Approved', 'Denied'];
  types = ['', 'Certification', 'Relocation to Client', 'Relocation to Training', 'Interview Expense', 'Sales Expense', 'Associate Travel Expense', 'Other'];

  constructor(private userService: UserService, private rService: ReimbursementService, private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('user') == null) {
      this.router.navigate(['login']);
    } else {
      this.user = JSON.parse(localStorage.getItem('user'));
      this.loadUsers();
      this.loadReimbursements();
    }
  }

  loadReimbursements() {
    this.reimbs = [];
    this.rService.getAllReimbursements();
    this.rService.allReimbursements.subscribe(ar => {
      if (ar != null) {
        ar = ar.filter(r => {
          console.log(r.author === this.user.id);
          return r.author !== this.user.id;
        });
        this.reimbs = ar;
        this.holdReimbs = ar;
      }
    });
  }

  loadUsers() {
    this.users = [];
    this.userService.getAllUsers().subscribe(u => {
      this.users = u;
    });
  }

  toDateString(num: number): string {
    let date = new Date(num);
    return date.toLocaleDateString();
  }

  // Pending requests on top
  sortByStatus() {
    this.reimbs.sort((x, y) => {
      return x.status - y.status;
    });
  }

  // Newest request on top
  sortById() {
    this.reimbs.sort((x, y) => {
      return y.id - x.id;
    });
  }

  setStatus(reimb: Reimbursement, status: number) {
    reimb.status = status;
    this.rService.updateReimbursement(reimb);
  }

  getName(reimb: Reimbursement) {
    const author = this.users.filter(u => {
      return u.id === reimb.author;
    })[0];

    return `${author.firstName} ${author.lastName}`;
  }


  filter(by: number) {
    // console.log('Filtering');
    this.reimbs = this.holdReimbs;
    if (by !== 0) {
      this.reimbs = this.reimbs.filter(r => {
        return r.status === by;
      });
    }
  }
}
