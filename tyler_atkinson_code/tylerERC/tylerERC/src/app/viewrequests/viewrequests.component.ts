import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementListService } from '../services/reimbursement-list.service';
import { Reimbursement } from '../models/reimbursement';
import { Location } from '@angular/common';
import { OReimbursementService } from '../oreimbursement.service';


@Component({
  selector: 'app-viewrequests',
  templateUrl: './viewrequests.component.html',
  styleUrls: ['./viewrequests.component.css']
})
export class ViewrequestsComponent implements OnInit {

  clickMessage = '';
  
  reimbursements: Reimbursement[];
  
  constructor(private reimbursementListService: ReimbursementListService, private oneReimburseService: OReimbursementService){}
  
  ngOnInit() {
    this.getReimbursement();
    console.log(this.reimbursements);
  }

  getReimbursement() {
  this.reimbursementListService.getReimbursement()
  .subscribe(reimbursements => this.reimbursements = reimbursements);
  console.log(this.reimbursements);
}

logged1(request:Reimbursement) {
  // console.log(id);
  request.rq_status_id = 4;
  this.oneReimburseService.updateReimbursement(request).subscribe((r)=>{})
  this.clickMessage = "Request is APPROVED By Michael Scott";
  

}

logged2(request:Reimbursement) {
  request.rq_status_id = 5;
  this.oneReimburseService.updateReimbursement(request).subscribe((r)=>{})
  this.clickMessage = "Request is DENIED By Michael Scott" 

}




}
