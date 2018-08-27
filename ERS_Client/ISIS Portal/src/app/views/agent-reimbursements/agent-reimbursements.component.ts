import { Reimbursement } from './../../models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agent-reimbursements',
  templateUrl: './agent-reimbursements.component.html',
  styleUrls: ['./agent-reimbursements.component.css']
})
export class AgentReimbursementsComponent implements OnInit {
  rb : Reimbursement[];
  id : number;
  constructor(private httpClient: HttpClient) { }

  ngOnInit() {

    }

    getEmpReimbursements() {
      this.httpClient.get<Reimbursement[]>('http://localhost:8080/ERS/EmployeeReimbursementsServlet?empId=' + this.id)
    .subscribe(data => {
      this.rb = data;
        console.log(this.rb);
        if (this.rb == null) {
          alert("No reimbursements for that user.");
        }
      }
    )
    }
}
