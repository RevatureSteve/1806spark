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
  id;

  constructor(private logged: LoggedInService, private reim: ReimbursementsListService, private route: ActivatedRoute) {
   }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.user = this.logged.getLoggedInUser();
    console.log(this.id);
    this.getReimbursementsById(this.id);
  }

  getReimbursementsById(id) {
    this.reim.getReimbursementsById(id).subscribe(x => this.reimbursement = x);
    console.log(this.reimbursement);
  }




}
