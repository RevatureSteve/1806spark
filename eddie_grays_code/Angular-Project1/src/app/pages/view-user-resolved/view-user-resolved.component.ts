import { Reimbursement } from './../../models/reimbursement.model';
import { User } from './../../models/user.model';
import { ReimbursementService } from './../../services/reimbursement.service';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-user-resolved',
  templateUrl: './view-user-resolved.component.html',
  styleUrls: ['./view-user-resolved.component.css']
})
export class ViewUserResolvedComponent implements OnInit {

  user: User;
  reimbursement: Reimbursement[];

  constructor(private userService: UserService, private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.user = this.userService.user;
    console.dir(this.user);
    this.viewReimbursement(1);
  }

  viewReimbursement(uId: number) {
    this.reimbursementService.viewAllResolvedReimbursementsById(uId)
    .subscribe((resp: any) => this.reimbursement = resp);
  }

}
