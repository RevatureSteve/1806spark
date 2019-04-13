import { Component, OnInit } from '@angular/core';
import {Reimbursement} from '../reimbursement';
import {DataServiceService} from '../data-service.service';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {

  constructor(private data: DataServiceService, public router: Router) { }

  ngOnInit() {
  }

  submitRequest (amt, opt, desc){
    const reimbursement = {
      employeeId: this.data.user.userID,
      amount: parseInt(amt),
      requestTypeId: parseInt(opt),
      description: desc
    }
    console.log(reimbursement)
    this.data.submitRequest(reimbursement).subscribe((data) => {alert("Reimbursement submitted")});
  }

}
