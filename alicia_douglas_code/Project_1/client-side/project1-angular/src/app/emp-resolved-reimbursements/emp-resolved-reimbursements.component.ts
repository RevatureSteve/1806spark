import { Component, OnInit } from '@angular/core';
import { Reimbursements } from '../models/reimbursements.model';
import { ReimbursementsService } from '../reimbursements.service';
import { CurrentUserService } from '../current-user.service';

@Component({
  selector: 'app-emp-resolved-reimbursements',
  templateUrl: './emp-resolved-reimbursements.component.html',
  styleUrls: ['./emp-resolved-reimbursements.component.css']
})
export class EmpResolvedReimbursementsComponent implements OnInit {

  user;

  reimbs: Reimbursements[];

  constructor(private reimbursementsService: ReimbursementsService, private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    console.log(this.user);
    this.getEmployeeResolved();
  }

  getCurrentUser() {
    this.user = this.currentUser.getCurrentUser();
    console.log(this.user);
  }

  getEmployeeResolved() {
    // const id = 1; // hard coed for now , change back later
    const id = this.user.u_id;
    this.reimbursementsService.getResolvedReimbursemetsById(id)
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

}
