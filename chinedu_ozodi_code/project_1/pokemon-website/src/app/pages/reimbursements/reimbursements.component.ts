import { Reimbursement } from './../../models/reimbursement';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { ReimbursementService } from '../../services/reimbursement.service';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  reimbs: Reimbursement[] = [];
  constructor(
    private login: LoginService,
    private reimbursementService: ReimbursementService
  ) { }

  ngOnInit() {
    if (this.login.currentUser) {
      this.reimbursementService.getReimbursementsByUserId(this.login.currentUser.uId).subscribe(reimbs => {
        this.reimbs = reimbs;
      });
    } else {
      this.login.checkSession();
    }
  }

}
