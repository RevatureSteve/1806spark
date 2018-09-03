import { Reimbursements } from './../models/Reimbursements';
import { ReimbursementServiceService } from './../services/reimbursement-service.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-manager-homepage',
  templateUrl: './manager-homepage.component.html',
  styleUrls: ['./manager-homepage.component.css']
})
export class ManagerHomepageComponent implements OnInit {
  data: Reimbursements[];
  constructor(private reimbursement: ReimbursementServiceService) { }

  ngOnInit() {
    this.reimbursement.getReimbursements().subscribe(
    reimbursement => this.data = reimbursement
    );
  }

  approveRequest(i: number) {
    const singleR = this.data[i];
    singleR.rq_status_id = 1;
    const singleRlist = [];
    singleRlist.push(singleR);
    this.reimbursement.updateReimbursements(singleRlist).subscribe();
  }
  denyRequest(i: number) {
    const singleR = this.data[i];
    singleR.rq_status_id = 2;
    const singleRlist = [];
    singleRlist.push(singleR);
    this.reimbursement.updateReimbursements(singleRlist).subscribe();
  }
}
