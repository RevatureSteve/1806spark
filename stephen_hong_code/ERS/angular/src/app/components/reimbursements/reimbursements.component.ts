import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';
import { Router } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

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
    this.rService.getReimbursementsForUser(this.user);
    this.rService.userReimbursements.subscribe(ur => {
      this.reimbs = ur;
      this.holdReimbs = ur;
    });
  }

  loadUsers() {
    this.users = [];
    this.userService.getAllUsers().subscribe(u => {
      this.users = u;
    });
  }

  toDateString(num: number): string{
    let date = new Date(num);
    return date.toLocaleDateString();
  }

  create(){
    this.router.navigate(['create-reimbursement']);
  }

  // Pending requests on top
  sortByStatus(){
    this.reimbs.sort((x, y) => {
      return x.status - y.status;
    });
  }

  // Newest request on top
  sortById(){
    this.reimbs.sort((x, y) => {
      return x.id - y.id;
    });
  }

  // Newest requests on top
  sortByTimeSubmitted(){
    this.reimbs.sort((x, y) => {
      return parseInt(y.timeSubmitted.toString()) - parseInt(x.timeSubmitted.toString());
    });
  }

  setStatus(reimb: Reimbursement, status: number) {
    reimb.status = status;
    this.rService.updateReimbursement(reimb);
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
