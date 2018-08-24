import { LoggedInService } from './../logged-in.service';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementsListService } from './../reimbursements-list.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Reimbursement } from '../reimbursement';

@Component({
  selector: 'app-view-reimbursements',
  templateUrl: './view-reimbursements.component.html',
  styleUrls: ['./view-reimbursements.component.css']
})
export class ViewReimbursementsComponent implements OnInit {

  user: User;
  reimbursement: Reimbursement[];

  constructor(private reimbursementList: ReimbursementsListService, private route: ActivatedRoute, private logged: LoggedInService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
    this.getReimbursements();
  }

  getReimbursements() {
    this.reimbursementList.getAllReimbursements().subscribe(rb => this.reimbursement = rb);
  }

}
