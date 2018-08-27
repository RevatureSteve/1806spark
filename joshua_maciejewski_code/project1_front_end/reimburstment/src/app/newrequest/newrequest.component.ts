import { ReimbursementService } from './../reimbursement.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';

@Component({
  selector: 'app-newrequest',
  templateUrl: './newrequest.component.html',
  styleUrls: ['./newrequest.component.css']
})
export class NewrequestComponent implements OnInit {

  user: User;

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('user'));
  }


  newReim(amt, description, rqTypeId) {
    const empUId = this.user.u_id;
    const img = null;
    console.log(amt);
    console.log(description);
    console.log(rqTypeId);
  

    this.reimbursementService.createReimbursement(empUId, amt, description, rqTypeId, img)
    .subscribe(reim => console.log(reim));

    
      }
}
