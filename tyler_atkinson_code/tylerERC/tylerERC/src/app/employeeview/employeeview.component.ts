import { Component, OnInit } from '@angular/core';
import { LoggedUserService } from '../services/logged-user.service';
import { User } from '../models/user';
import { ReimbursementListService } from '../services/reimbursement-list.service';
import { Reimbursement } from '../models/reimbursement';

@Component({
  selector: 'app-employeeview',
  templateUrl: './employeeview.component.html',
  styleUrls: ['./employeeview.component.css']
})
export class EmployeeviewComponent implements OnInit {

  user: User;

  reimbursements: Reimbursement[];

  constructor(private logged: LoggedUserService, private reimbursementListService: ReimbursementListService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedUser();
    console.log(this.user);
    this.getReimbursementByEmpId();
    console.log(this.reimbursements);
  }
  
    getReimbursementByEmpId() {
    console.log(this.user.uid);
    this.reimbursementListService.getReimbursementByEmpId(this.user.uid)
  
    .subscribe(reimbursements => this.reimbursements = reimbursements);
    console.log(this.reimbursements);
  }
  

    
  
  }