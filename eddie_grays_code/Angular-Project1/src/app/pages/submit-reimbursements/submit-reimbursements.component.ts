import { UserService } from './../../services/user.service';
import { ReimbursementService } from './../../services/reimbursement.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-submit-reimbursements',
  templateUrl: './submit-reimbursements.component.html',
  styleUrls: ['./submit-reimbursements.component.css']
})
export class SubmitReimbursementsComponent implements OnInit {

  reimb;

  constructor(private reimbursementService: ReimbursementService, private userService: UserService) { }

  ngOnInit() {
    this.reimb = {
      empId: this.userService.currentUser().uId,
      amount: 0,
      description: '',
      imageUrl: 'reciept',
      reqTypeId: 0
      };
  }

  submitReimbursementRequest() {
    this.reimbursementService.submitReimbursementRequest(this.reimb).subscribe(resp => {});
  }

}
