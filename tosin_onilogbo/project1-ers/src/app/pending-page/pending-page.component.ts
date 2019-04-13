import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { Reimbursement } from '../reimbursement';
import { User } from '../userclass';

@Component({
  selector: 'app-pending-page',
  templateUrl: './pending-page.component.html',
  styleUrls: ['./pending-page.component.css']
})
export class PendingPageComponent implements OnInit {
  reimbursement: Reimbursement [] = [];
  user: User; 
  empId;
  empReim: Reimbursement [] = [];
  constructor(private data: DataServiceService) { }

  ngOnInit() {
    this.getAllReimbursement();
    this.byEmployeeId();
    this.user = this.data.user;
    this.empId = this.user.userID;
  }

  getAllReimbursement () {
      this.data.readRequests().subscribe(reim => {
        this.reimbursement = reim;
        console.log(this.reimbursement);
        this.byEmployeeId();//erase if don't work
      });
  }

  byEmployeeId (){
    console.log(this.reimbursement);
  for(let i = 0; i < this.reimbursement.length; i++){
    console.log(this.reimbursement[i]);
    if(this.reimbursement[i].employeeId == this.empId && this.reimbursement[i].requestStatusId == 1) {
      this.empReim.push(this.reimbursement[i]);
    }
  }
  }
}
