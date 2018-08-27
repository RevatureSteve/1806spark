import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementService } from './../reimbursement.service';
import { Reim } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/reim';


@Component({
  selector: 'app-managerrequestsbyid',
  templateUrl: './managerrequestsbyid.component.html',
  styleUrls: ['./managerrequestsbyid.component.css']
})
export class ManagerrequestsbyidComponent implements OnInit {

  reims: Reim[];

  constructor(private route: ActivatedRoute, private reimbursementService: ReimbursementService) { }

  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.reimById(id);

  }
  
  reimById(id) {
    this.reimbursementService.getReimById(id)
.subscribe(reimbursements => this.reims = reimbursements);

  }
}
