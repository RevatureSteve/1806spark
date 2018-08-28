import { Component, OnInit } from '@angular/core';
import { ReimbursementsService } from '../reimbursements.service';

@Component({
  selector: 'app-new-reimbursement',
  templateUrl: './new-reimbursement.component.html',
  styleUrls: ['./new-reimbursement.component.css']
})
export class NewReimbursementComponent implements OnInit {

  success = false;

  constructor(private reimbursementService: ReimbursementsService) { }

  ngOnInit() {
  }

  newReimbursement(amt, desc, type, img) {
    console.log('newReimbursement called');
    console.log(amt);
    console.log (desc);
    console.log(type);
    this.reimbursementService.createNewReimbursement(amt, desc, type, null).subscribe(r => this.success = true);
  }

}
