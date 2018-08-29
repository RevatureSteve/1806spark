import { Component, OnInit } from '@angular/core';
import { ReimbursementsService } from '../reimbursements.service';

@Component({
  selector: 'app-new-reimbursement',
  templateUrl: './new-reimbursement.component.html',
  styleUrls: ['./new-reimbursement.component.css']
})
export class NewReimbursementComponent implements OnInit {

  constructor(private reimbursementService: ReimbursementsService) { }

  ngOnInit() {
  }

  newReimbursement(amt, desc, type) {
    console.log('newReimbursement called');
    console.log(amt);
    console.log (desc);
    console.log(type);
    this.reimbursementService.createNewReimbursement(amt, desc, type).subscribe(r => alert('New reimbursement submited'));
  }

}
