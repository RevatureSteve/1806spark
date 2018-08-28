import { Reimbursement } from './../../models/reimbursement.model';
import { ReimbursementService } from './../../services/reimbursement.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manage-reimbursements',
  templateUrl: './manage-reimbursements.component.html',
  styleUrls: ['./manage-reimbursements.component.css']
})
export class ManageReimbursementsComponent implements OnInit {

  reimbursement: Reimbursement[];

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.reimbursementService.viewAllPendingReimbursements()
    .subscribe(resp => this.reimbursement = resp);
  }

}
