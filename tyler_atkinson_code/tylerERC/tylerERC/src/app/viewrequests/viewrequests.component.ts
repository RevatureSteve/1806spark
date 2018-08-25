import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementListService } from '../services/reimbursement-list.service';
import { Reimbursement } from '../models/reimbursement';
import { Location } from '@angular/common';


@Component({
  selector: 'app-viewrequests',
  templateUrl: './viewrequests.component.html',
  styleUrls: ['./viewrequests.component.css']
})
export class ViewrequestsComponent implements OnInit {
  
  reimbursements: Reimbursement[];
  
  constructor(private reimbursementListService: ReimbursementListService){}
  
  ngOnInit() {
    this.getReimbursement();
  }

  getReimbursement()  {
  this.reimbursementListService.getReimbursement()
  .subscribe(reimbursements => this.reimbursements = reimbursements)
}





}
