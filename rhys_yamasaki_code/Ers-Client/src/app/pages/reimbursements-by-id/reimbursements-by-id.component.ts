import { ActivatedRoute } from '@angular/router';
import { ReimbursementsListService } from '../../reimbursements-list.service';
import { LoggedInService } from '../../logged-in.service';
import { User } from '../../models/user';
import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement';

@Component({
  selector: 'app-reimbursements-by-id',
  templateUrl: './reimbursements-by-id.component.html',
  styleUrls: ['./reimbursements-by-id.component.css']
})
export class ReimbursementsByIdComponent implements OnInit {

  user: User;
  reimbursement: Reimbursement[];
  userId;

  constructor(private logged: LoggedInService, private reim: ReimbursementsListService, private route: ActivatedRoute) {
   }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
    this.userId = this.route.snapshot.paramMap.get('id');
    console.log(this.userId);
    this.getReimbursementsById(this.userId);
  }

  getReimbursementsById(id) {
    this.reim.getReimbursementsById(id).subscribe(x => this.reimbursement = x);
  }




}
