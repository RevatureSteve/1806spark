import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementListService } from '../../services/reimbursement-list.service';
import { Reimbursement } from '../../models/reimbursement';
import { Location } from '@angular/common';

@Component({
  selector: 'app-reimbursement-details',
  templateUrl: './reimbursement-details.component.html',
  styleUrls: ['./reimbursement-details.component.css']
})
export class ReimbursementDetailsComponent implements OnInit {
  reimbursement: Reimbursement;
  constructor(private location: Location, private reimbSer: ReimbursementListService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getReimbursement();
  }

  goBack(): void {
    this.location.back();
  }

  getReimbursement(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reimbSer.getReimbursementsArray().subscribe(reimbursements => {
      const reimbs = reimbursements;
      reimbs.forEach(reimb => {
        console.log(reimb);
        if (reimb.rId === id) {
          this.reimbursement = reimb;
        }
      });
    });
  }
}
