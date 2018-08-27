import { LoggedInService } from './../../logged-in.service';
import { Users } from './../../models/Users';
import { CreateReimbService } from './../../create-reimb.service';
import { Reimbursement } from './../../models/Reimbursement';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-reimb',
  templateUrl: './create-reimb.component.html',
  styleUrls: ['./create-reimb.component.css']
})
export class CreateReimbComponent implements OnInit {
  createReimb: Reimbursement;
  user: Users;

  constructor(private httpClient: HttpClient, private routes: Router, private createReimbService: CreateReimbService,
    private loggedInService: LoggedInService) { }

  ngOnInit() {
    this.user = this.loggedInService.getLoggedInUser();
  }

  // Function to display what is going to be sent to the database
  capture(rq_Type_Id) {
    console.log(rq_Type_Id);
  }

  creatingReimb(amt, u_Id, rq_Type_Id, description): void {
    console.log('service: creatingReimb');
    this.createReimbService.getReimb(amt, u_Id, rq_Type_Id, description).subscribe(
      create => {
        console.log('creating reimbursement submission');
      }
    );
  }
}
