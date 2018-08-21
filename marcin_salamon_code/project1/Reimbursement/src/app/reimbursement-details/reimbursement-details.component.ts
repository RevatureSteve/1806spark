import { Component, OnInit } from '@angular/core';
import { ReimbursementListService } from '../reimbursement-list.service';
import { Reimbursement } from '../reimbursement';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reimbursement-details',
  templateUrl: './reimbursement-details.component.html',
  styleUrls: ['./reimbursement-details.component.css']
})
export class ReimbursementDetailsComponent implements OnInit {
  reimbursement: Reimbursement;
  constructor(private location: Location, private reimbSer: ReimbursementListService, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  goBack(): void {
    this.location.back();
  }

  getHero(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reimbSer.getReimbursement(id)
      .subscribe(reimbursement => this.reimbursement = reimbursement);
  }
}
