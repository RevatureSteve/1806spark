import { Reimbursements } from './../models/Reimbursements';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-create-reimbursement',
  templateUrl: './create-reimbursement.component.html',
  styleUrls: ['./create-reimbursement.component.css']
})
export class CreateReimbursementComponent implements OnInit {

 reimbursement: Reimbursements;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {

     /* this.reimbursement = {
      emp_u_id: 0,
      mgr_u_id: 0,
      amt: 0,
      description: '',
      img: null,
      timesubmission: '',
      rq_type_id: 0,
      rq_status_id: 0, 
    };

    SubmitReimbursement(){
      console.log(this.reimbursement);
    }

     SubmitReimbursement(reimbursement: Reimbursement) {
      this.httpClient.post('http://localhost:8080/NewReimbursementServlet', reimbursement).subscribe;
      );
      console.log(this.validUser); */
      }

}
