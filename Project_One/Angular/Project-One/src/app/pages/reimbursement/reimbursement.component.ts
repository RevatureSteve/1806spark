import { Reimbursement } from './../../models/Reimbursement';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {
  postR: Reimbursement[];

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getReimb();
  }

  getReimb() {
    this.data.getReimbs().subscribe(
      data => this.postR = data);
  }
}
