import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-reimbursements',
  templateUrl: './all-reimbursements.component.html',
  styleUrls: ['./all-reimbursements.component.css']
})
export class AllReimbursementsComponent implements OnInit {
  /* reimbursements: Reimbursement[]; */

  constructor() { }

  ngOnInit() {
  }

  getReimbursements(): void {
  /* this.reimbService.getAllReimbursements();
  this.reimbService.getReimbursementsArray().subscribe(reimbursements => this.reimbursements =
  this.sortReimbursements(reimbursements)); */
  }


}
