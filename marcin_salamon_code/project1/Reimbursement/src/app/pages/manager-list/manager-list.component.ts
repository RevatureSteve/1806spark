import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement';
import { ReimbursementListService } from '../../services/reimbursement-list.service';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {
  reimbursement: Reimbursement[];
  constructor(private reimbService: ReimbursementListService) { }

  ngOnInit() {
  }

}
