import { ActivatedRoute, Router, ParamMap, RoutesRecognized } from '@angular/router';
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

  constructor(private logged: LoggedInService, private reim: ReimbursementsListService, private route: ActivatedRoute,
    private router: Router) {
    // this.route.paramMap.subscribe(params => {
    //   this.userId = +params.get('id');
    // });
   }

  ngOnInit() {
    this.userId = +this.route.snapshot.queryParamMap.get('user_id');
    this.user = this.logged.getLoggedInUser();
    console.log(this.userId);
    this.getReimbursementsById(this.userId);
  }

  getReimbursementsById(id) {
    this.reim.getReimbursementsById(id).subscribe(x => this.reimbursement = x);
  }




}
