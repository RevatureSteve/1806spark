import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {
  reimbursement: Reimbursement[];
  constructor() { }

  ngOnInit() {
  }

}
