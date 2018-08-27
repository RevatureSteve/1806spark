import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from './../reimbursement.service';
import { User } from '../models/user';
//import { Router } from '@angular/router';
import { ActivatedRoute, RouterModule, Routes, Router } from '@angular/router';
import { Reim } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/reim';

@Component({
  selector: 'app-managerpending',
  templateUrl: './managerpending.component.html',
  styleUrls: ['./managerpending.component.css']
})
export class ManagerpendingComponent implements OnInit {

  user: User;

  reims : Reim[];
  reim : Reim;

  constructor(private reimbursementService: ReimbursementService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('user'));
    this.getmanagerpending();
  }

  getmanagerpending() {

    this.reimbursementService.pendingreimbursements()
    .subscribe(reimbursements => this.reims = reimbursements);
  }

  
  reimStatus(rId, rqStatusId) {
    this.user=JSON.parse(localStorage.getItem('user'));
    console.log(this.user)
    const mgrUId = this.user.u_id;
    console.log(mgrUId);
    // console.log(this.reim.rId);
    // const rId = this.reim.rId;
    // console.log(rId);

    this.reimbursementService.changeReimStatus(rId, mgrUId, rqStatusId)
    .subscribe(reimbursements => this.reim = reimbursements);
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() =>
    this.router.navigate(['managerpending']));

  }

}
