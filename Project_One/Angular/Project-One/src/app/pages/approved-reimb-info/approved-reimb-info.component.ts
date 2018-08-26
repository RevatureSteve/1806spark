import { Reimbursement } from './../../models/Reimbursement';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-approved-reimb-info',
  templateUrl: './approved-reimb-info.component.html',
  styleUrls: ['./approved-reimb-info.component.css']
})
export class ApprovedReimbInfoComponent implements OnInit {
  postA: Reimbursement[];

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getReimb();
  }

  getReimb() {
    this.data.getApprovedReimb().subscribe(
      data => this.postA = data);
  }

}
