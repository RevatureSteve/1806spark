import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from './../reimbursement.service';
import { User } from '../models/user';
import { Reim } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/reim';


@Component({
  selector: 'app-employeepending',
  templateUrl: './employeepending.component.html',
  styleUrls: ['./employeepending.component.css']
})
export class EmployeependingComponent implements OnInit {

  user: User;

  reims : Reim[];

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() { 
    this.user=JSON.parse(localStorage.getItem('user'));
    console.log("init")
    this.getemployeepending();
  }

  getemployeepending() {
    const u_id = this.user.u_id;
    console.log(u_id + "component.ts")
 
    this.reimbursementService.employeeviewpending(u_id)
    .subscribe(reimbursements => this.reims = reimbursements);

   

}
}