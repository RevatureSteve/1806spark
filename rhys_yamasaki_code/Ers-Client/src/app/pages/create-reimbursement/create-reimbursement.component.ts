import { Router } from '@angular/router';
import { ReimbursementsListService } from './../../reimbursements-list.service';
import { User } from './../../models/user';
import { HttpClient } from '@angular/common/http';
import { Type } from '../../models/type';
import { Component, OnInit } from '@angular/core';
import { LoggedInService } from '../../logged-in.service';

@Component({
  selector: 'app-create-reimbursement',
  templateUrl: './create-reimbursement.component.html',
  styleUrls: ['./create-reimbursement.component.css']
})
export class CreateReimbursementComponent implements OnInit {

  user: User;
  type: Type[];


  constructor(private http: HttpClient, private logged: LoggedInService, private reimb: ReimbursementsListService,
  private router: Router) { }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
    this.getType();
  }

  getType() {
    this.reimb.getType().subscribe(type => this.type = type).unsubscribe();
  }



  createReimbursement(userId, amount, desc, type) {
    this.reimb.submitReimbursement(userId, amount, desc, type).subscribe(x => {});
    this.reimb.getEmployeePending(this.user.user_id).subscribe(x => this.reimb.reimbursement);
    this.router.navigateByUrl('/easteregg', {skipLocationChange: true}).then(() =>
    this.router.navigate(['/employee/home']));
  }
}
