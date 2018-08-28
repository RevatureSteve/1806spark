import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../models/reimbursement';
import { ReimbursementListService } from '../services/oneReimbursement.service';
import { OReimbursementService } from '../oreimbursement.service';
import { LoggedUserService } from '../services/logged-user.service';
import { User } from '../models/user';



@Component({
  selector: 'app-one-reimbursement',
  templateUrl: './one-reimbursement.component.html',
  styleUrls: ['./one-reimbursement.component.css']
})
export class OneReimbursementComponent implements OnInit {

  clickMessage = '';
  
  reimbursements: Reimbursement[];

  currentReim: Reimbursement;

  employee: User;

  id: number;
  
  constructor(private reimbursementListService: ReimbursementListService, private reimbursementService: OReimbursementService, private loginService : LoggedUserService){
    // this.employee = this.loginService.getLoggedUser
  }
  
  ngOnInit() {
    this.getReimbursement(this.id);
    console.log(this.reimbursements);
    this.currentReim = {
      "rid": 0,
      "empuid" : 0,
      "mgruid" : 0,
      "rqtypeid" : 0,
      "rq_status_id" : 0,
      "amt" : 0,
      "description" :'', 
      "timesubmission" :'', 
      "reimbursementrequests" : null,
      
    }
  }


  getReimbursement(rid) {
this.reimbursementService.getReimbursementByUid(rid).subscribe(reimbursements => this.reimbursements = reimbursements);
  console.log("looking for Id:" + rid)
  console.log(this.reimbursements);
}

logged1(request:Reimbursement) {
  // console.log(id);
  this.currentReim = request;
  this.currentReim.rq_status_id = 4;
  this.updateReimbursement(this.currentReim);
  this.clickMessage = "Request is APPROVED By Michael Scott";

}

logged2(request:Reimbursement) {
  this.currentReim = request;
  this.currentReim.rq_status_id = 5;
  console.log(this.currentReim);
  this.updateReimbursement(this.currentReim);
  this.clickMessage = "Request is DENIED By Michael Scott";

}

updateReimbursement(req:Reimbursement){
  this.reimbursementService.updateReimbursement(req).subscribe((r)=>{} );

}


}
