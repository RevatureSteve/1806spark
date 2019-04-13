import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { Reimbursement } from '../reimbursement';
import { User } from '../userclass';

@Component({
  selector: 'app-view-requests',
  templateUrl: './view-requests.component.html',
  styleUrls: ['./view-requests.component.css']
})
export class ViewRequestsComponent implements OnInit {

  reimbursement: Reimbursement [];
  user: User; 
  empId;
  // empReim: Reimbursement [];
  constructor(private data: DataServiceService) { }

  ngOnInit() {
    this.getAllReimbursement();
    this.user = this.data.user;
    this.empId = this.user.userID;
  }

  getAllReimbursement () {
      this.data.readRequests().subscribe(reim => {
        this.reimbursement = reim
      });
  }
  
  approve (reimId){
    const reim = {
      requestId: reimId,
      requestStatusId: 3,
      managerId: this.empId
    }
    this.data.updateRequestStatus(reim).subscribe(stat => {
      alert('Request Approved')
    });
  }

  deny (reimId){
    const reim = {
      requestId: reimId,
      requestStatusId: 2,
      managerId: this.empId
    }
    this.data.updateRequestStatus(reim).subscribe(stat => {
      alert('Request Denied')
    });
  }
  
  updateStatus (reim){
    for (let i = 0; i < this.reimbursement.length; i++){
      if(reim.requestId == this.reimbursement[i].requestId){
        this.reimbursement[i].requestStatusId = reim.requestStatusId;
      }
    }

  }
}