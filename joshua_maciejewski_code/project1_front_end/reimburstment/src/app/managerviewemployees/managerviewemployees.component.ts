import { ReimbursementService } from './../reimbursement.service';
import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { Reim } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/reim';


@Component({
  selector: 'app-managerviewemployees',
  templateUrl: './managerviewemployees.component.html',
  styleUrls: ['./managerviewemployees.component.css']
})
export class ManagerviewemployeesComponent implements OnInit {

users: User[];

reims: Reim[];

  constructor(private UserService: UserService, private router: Router, private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.getallemployees();
  }

  getallemployees() {
    this.UserService.getallemployees()
    .subscribe(users => this.users = users);

  }

  requestsbyid(u_id) {
this.router.navigate(['managerrequestsbyid/' + u_id]);
this.reimbursementService.getReimById(u_id)
.subscribe(reimbursements => this.reims = reimbursements);
  }

  
}



