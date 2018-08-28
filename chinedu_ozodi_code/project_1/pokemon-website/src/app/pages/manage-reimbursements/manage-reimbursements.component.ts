import { ReimbursementService } from './../../services/reimbursement.service';
import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manage-reimbursements',
  templateUrl: './manage-reimbursements.component.html',
  styleUrls: ['./manage-reimbursements.component.css']
})
export class ManageReimbursementsComponent implements OnInit {


  reimbs: Reimbursement[] = [];
  constructor(
    private login: LoginService,
    private reimbursementService: ReimbursementService,
    public router: Router
  ) { }

  ngOnInit() {
    console.log('MR current user ' + this.login.currentUser);
    if (this.login.currentUser) {
      console.log('[LOG] MR current user position ' + this.login.currentUser.posId);
    }
    if (this.login.currentUser && this.login.currentUser.posId === 2) {

      this.reimbursementService.getAllReimbursements().subscribe(reimbs => {
        this.reimbs = reimbs;
      });
    } else {
      this.login.checkSession();
      this.router.navigate(['reimbursements']);
    }
  }
}
