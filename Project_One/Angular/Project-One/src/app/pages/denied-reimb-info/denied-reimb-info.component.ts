import { Reimbursement } from './../../models/Reimbursement';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-denied-reimb-info',
  templateUrl: './denied-reimb-info.component.html',
  styleUrls: ['./denied-reimb-info.component.css']
})
export class DeniedReimbInfoComponent implements OnInit {
  postD: Reimbursement[];

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getReimb();
  }

  getReimb() {
    this.data.getDeniedReimb().subscribe(
      data => this.postD = data);
  }
}