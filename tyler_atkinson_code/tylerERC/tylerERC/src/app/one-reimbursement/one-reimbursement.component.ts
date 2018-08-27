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

  employee: User;

  id: number;
  
  constructor(private reimbursementListService: ReimbursementListService, private reimbursementService: OReimbursementService, private loginService : LoggedUserService){
    // this.employee = this.loginService.getLoggedUser
  }
  
  ngOnInit() {
    this.getReimbursement(this.id);
    console.log(this.reimbursements);
  }


  getReimbursement(rid) {
this.reimbursementService.getReimbursementByUid(rid).subscribe(reimbursements => this.reimbursements = reimbursements);
  console.log("looking for Id:" + rid)
  console.log(this.reimbursements);
}

logged1(id) {
  console.log(id);
  this.clickMessage = "Request is APPROVED By Michael Scott";

}

logged2(id) {
  console.log(id);
  this.clickMessage = "Request is DENIED By Michael Scott";

}




}
