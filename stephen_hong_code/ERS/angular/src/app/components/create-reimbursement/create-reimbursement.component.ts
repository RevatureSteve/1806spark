import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';
import { Router } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement';
import { User } from '../../models/user';

@Component({
  selector: 'app-create-reimbursement',
  templateUrl: './create-reimbursement.component.html',
  styleUrls: ['./create-reimbursement.component.css']
})
export class CreateReimbursementComponent implements OnInit {

  reimb: Reimbursement = new Reimbursement();
  message: string;
  valid = false;

  constructor(private rService: ReimbursementService, private router: Router) { }

  ngOnInit() {
    let user: User = JSON.parse(localStorage.getItem('user'));
    this.reimb.id = 0;
    this.reimb.resolver = null;
    this.reimb.status = 1;
    this.reimb.author = user.id;
    this.reimb.timeResolved = null;
    this.reimb.timeSubmitted = new Date();
  }

  createReimbursement() {
    console.log('In CreateReimbursementComponent.createReimbursement()');
    this.rService.createReimbursement(this.reimb);
    this.reimb.description = null;
    this.reimb.amount = null;
    this.reimb.type = null;
    this.valid = false;
  }

  validate() {
    console.log('Validating');
    this.message = '';
    this.valid = true;
  }
}
