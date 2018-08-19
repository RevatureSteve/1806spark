import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../reimbursement';
import { ReimbursementListService } from '../reimbursement-list.service';

@Component({
  selector: 'app-reimbursement-list',
  templateUrl: './reimbursement-list.component.html',
  styleUrls: ['./reimbursement-list.component.css']
})
export class ReimbursementListComponent implements OnInit {
  reimbursements: Reimbursement[];
  constructor(private reimbService: ReimbursementListService) { }

  ngOnInit() {
    this.reimbService.getPendingReimbursementsById(1);
    this.getReimbursements();
  }

  getReimbursements(): void {
    this.reimbService.getReimbursementsArray().subscribe(reimbursements => this.reimbursements = reimbursements);
  }

}
