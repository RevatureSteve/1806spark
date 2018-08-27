import { DataService } from './../../data.service';
import { Reimbursement } from './../../models/Reimbursement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reimbursement-information',
  templateUrl: './reimbursement-information.component.html',
  styleUrls: ['./reimbursement-information.component.css']
})
export class ReimbursementInformationComponent implements OnInit {
  postAll: Reimbursement[];

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getReimb();
  }

  getReimb() {
    this.data.getReimbs().subscribe(
      data => this.postAll = data);
  }
}
