import { ReimbursementsService } from './../reimbursements.service';
import { Component, OnInit } from '@angular/core';
import { Reimbursements } from '../models/reimbursements.model';

@Component({
  selector: 'app-manager-resolved-reimbursments',
  templateUrl: './manager-resolved-reimbursments.component.html',
  styleUrls: ['./manager-resolved-reimbursments.component.css']
})
export class ManagerResolvedReimbursmentsComponent implements OnInit {

  reimbs: Reimbursements[];

  constructor(private reimbService: ReimbursementsService) { }

  ngOnInit() {
    // this.getAllReimbursements();
  }

  getAllReimbursements() {
    this.reimbService.getAllReimbursements()
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

}
