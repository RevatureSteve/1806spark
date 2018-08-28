import { UsersService } from './../../users-service';
import { Reimbursement } from './../../models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agent-reimbursements',
  templateUrl: './agent-reimbursements.component.html',
  styleUrls: ['./agent-reimbursements.component.css']
})
export class AgentReimbursementsComponent implements OnInit {
  constructor(private httpClient: HttpClient, private service: UsersService) { }
  rb: Reimbursement[];
  id: number;
  usr = this.service.currentLoggedUser();
  user = JSON.stringify(this.usr);
  uu = this.user.toString();
  final = JSON.parse(this.uu);
  test() {
  console.log(this.final.empId);

  };
  ngOnInit() {
    this.test()
  }

  getEmpReimbursements() {
    this.httpClient.get<Reimbursement[]>('http://localhost:8080/ERS/EmployeeReimbursementsServlet?empId=' + this.final.empId)
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
