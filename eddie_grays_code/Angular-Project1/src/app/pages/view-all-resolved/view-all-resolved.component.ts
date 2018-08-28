import { Reimbursement } from './../../models/reimbursement.model';
import { ReimbursementService } from './../../services/reimbursement.service';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-all-resolved',
  templateUrl: './view-all-resolved.component.html',
  styleUrls: ['./view-all-resolved.component.css']
})
export class ViewAllResolvedComponent implements OnInit {

  reimbursement: Reimbursement[];

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.viewAllResolvedReimbursements();
  }

  viewAllResolvedReimbursements() {
    this.reimbursementService.viewAllResolvedReimbursements()
    .subscribe(resp => this.reimbursement = resp);
  }

}
