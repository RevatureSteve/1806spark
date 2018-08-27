import { Reimbursement } from './../../models/reimbursement';
import { Component, OnInit, Input } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';

@Component({
  selector: 'app-reimbursement-card',
  templateUrl: './reimbursement-card.component.html',
  styleUrls: ['./reimbursement-card.component.css']
})
export class ReimbursementCardComponent implements OnInit {

  @Input()
  reimb: Reimbursement;

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
  }

  accept() {
    this.reimb.rqStatusId = 4;
    this.reimbursementService.updateReimbursement(this.reimb).subscribe();
  }

  decline() {
    this.reimb.rqStatusId = 3;
    this.reimbursementService.updateReimbursement(this.reimb).subscribe();
  }
}
