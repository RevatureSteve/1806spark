import { Component, OnInit } from '@angular/core';
import { Reimbursements } from '../models/reimbursements.model';
import { ReimbursementsService } from '../reimbursements.service';

@Component({
  selector: 'app-manager-reimbursements',
  templateUrl: './manager-reimbursements.component.html',
  styleUrls: ['./manager-reimbursements.component.css']
})
export class ManagerReimbursementsComponent implements OnInit {

  reimbs: Reimbursements[];

  constructor(private reimbService: ReimbursementsService) { }

  ngOnInit() {
    this.getAllReimbursements();
  }

  getAllReimbursements() {
    this.reimbService.getAllReimbursements()
      .subscribe(reimbursements => this.reimbs = reimbursements);
  }

}
