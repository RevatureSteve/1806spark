import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementListService } from '../../services/reimbursement-list.service';
import { Reimbursement } from '../../models/reimbursement';

@Component({
  selector: 'app-reimbursement-details',
  templateUrl: './reimbursement-details.component.html',
  styleUrls: ['./reimbursement-details.component.css']
})
export class ReimbursementDetailsComponent implements OnInit {
  reimbursement: Reimbursement;
  constructor(private reimbSer: ReimbursementListService, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  goBack(): void {
  }

  getHero(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reimbSer.getReimbursement(id)
      .subscribe(reimbursement => this.reimbursement = reimbursement);
  }
}
