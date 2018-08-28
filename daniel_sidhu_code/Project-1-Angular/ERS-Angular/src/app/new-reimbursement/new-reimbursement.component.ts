import { ReimbursementService } from './../services/reimbursement.service';
import { CurrentUserService } from './../services/current-user.service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users';

@Component({
  selector: 'app-new-reimbursement',
  templateUrl: './new-reimbursement.component.html',
  styleUrls: ['./new-reimbursement.component.css']
})
export class NewReimbursementComponent implements OnInit {

  user: Users;

  constructor(private currenUserService: CurrentUserService, private reimbursementService: ReimbursementService) { }

  ngOnInit() {
  }

  submitNewReimbursement(empUserId, amount, description, requestTypeId): void {

    console.log(empUserId);
    console.log(amount);
    console.log(description);
    console.log(requestTypeId);
    this.reimbursementService.createNewReimbursement(empUserId, Number.parseInt(amount), description, Number.parseInt(requestTypeId))
      .subscribe(create => {
        console.log('reimbursement submitted');
      });
  }
}
