import { Reimbursement } from './../../models/Reimbursement';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-pending-reimb-info',
  templateUrl: './pending-reimb-info.component.html',
  styleUrls: ['./pending-reimb-info.component.css']
})
export class PendingReimbInfoComponent implements OnInit {
  postP: Reimbursement[];

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getReimb();
  }

  getReimb() {
    this.data.getPendReimb().subscribe(
      data => this.postP = data);
  }
}
