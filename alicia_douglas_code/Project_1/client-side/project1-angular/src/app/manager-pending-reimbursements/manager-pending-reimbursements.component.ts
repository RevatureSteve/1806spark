import { Component, OnInit } from '@angular/core';
import { ReimbursementsService } from '../reimbursements.service';
import { Reimbursements } from '../models/reimbursements.model';

@Component({
  selector: 'app-manager-pending-reimbursements',
  templateUrl: './manager-pending-reimbursements.component.html',
  styleUrls: ['./manager-pending-reimbursements.component.css']
})
export class ManagerPendingReimbursementsComponent implements OnInit {

  reimbs: Reimbursements[];

  constructor(private reimbService: ReimbursementsService) { }

  ngOnInit() {
    this.getPendingReimbursements();
  }

  getPendingReimbursements() {
    this.reimbService.getPendingReimbursements()
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

}
