import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from './../reimbursement.service';
//import { User } from '../models/user';
import { Reim } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/reim';


@Component({
  selector: 'app-managerresolved',
  templateUrl: './managerresolved.component.html',
  styleUrls: ['./managerresolved.component.css']
})
export class ManagerresolvedComponent implements OnInit {

  reims : Reim[];

  constructor(private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    this.getmanagerresolved()
  }

getmanagerresolved() {
  this.reimbursementService.resolvedreimbursements()
  .subscribe(reimbursements => this.reims = reimbursements);
}

}
