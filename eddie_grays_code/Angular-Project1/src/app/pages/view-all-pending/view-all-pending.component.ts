import { ReimbursementService } from './../../services/reimbursement.service';
import { UserService } from './../../services/user.service';
import { Reimbursement } from './../../models/reimbursement.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-all-pending',
  templateUrl: './view-all-pending.component.html',
  styleUrls: ['./view-all-pending.component.css']
})
export class ViewAllPendingComponent implements OnInit {

  reimbursement: Reimbursement[];

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.viewAllPendingReimbursements();
  }

  viewAllPendingReimbursements() {
    this.reimbursementService.viewAllPendingReimbursements()
    .subscribe(resp => this.reimbursement = resp);
  }

}
