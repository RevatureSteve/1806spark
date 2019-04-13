import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { Reimbursement } from '../reimbursement';
import { User } from '../userclass';

@Component({
  selector: 'app-completed-page',
  templateUrl: './completed-page.component.html',
  styleUrls: ['./completed-page.component.css']
})
export class CompletedPageComponent implements OnInit {

  reimbursement: Reimbursement [] = [];
  user: User; 
  empId;
  empReim: Reimbursement [] = [];
  constructor(private data: DataServiceService) { }

  ngOnInit() {
    this.getAllReimbursement();
    this.user = this.data.user;
    this.empId = this.user.userID;
    this.byEmployeeId();
  }

  getAllReimbursement () {
      this.data.readRequests().subscribe(reim => {
        this.reimbursement = reim;
        console.log(this.reimbursement);
        this.byEmployeeId();
      });
  }

  byEmployeeId (){
    console.log('employeeid');
    console.log(this.reimbursement);
  for(let i = 0; i < this.reimbursement.length; i++){
    console.log(this.reimbursement[i]);
    console.log(this.empId )
    if(this.reimbursement[i].employeeId == this.empId && this.reimbursement[i].requestStatusId != 1) {
      console.log(this.empReim);
      this.empReim.push(this.reimbursement[i]);
    }
  }
  }
}
