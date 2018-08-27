import { User } from '../../models/user';
import { LoggedInService } from '../../logged-in.service';
import { ActivatedRoute, RouterModule, Routes, Router } from '@angular/router';
import { ReimbursementsListService } from '../../reimbursements-list.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement';

@Component({
  selector: 'app-view-reimbursements',
  templateUrl: './view-reimbursements.component.html',
  styleUrls: ['./view-reimbursements.component.css']
})
export class ViewReimbursementsComponent implements OnInit {

  user: User;
  reimbursement: Reimbursement[];

  constructor(private reimbursementList: ReimbursementsListService, private route: ActivatedRoute, private logged: LoggedInService,
  private router: Router) { }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
    this.getReimbursements();
  }

  getReimbursements() {
    this.reimbursementList.getAllReimbursements().subscribe(rb => this.reimbursement = rb);
  }

  resolveReimbursement(userId, rId, statusId) {
    this.reimbursementList.resolveReimbursement(userId, rId, statusId).subscribe(x => {});
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() =>
    this.router.navigate(['/manager/home']));
  }

}
