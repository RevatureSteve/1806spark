import { Component, OnInit } from '@angular/core';
import { DecisionsService } from '../../../services/decisions.service';
import { Reimbursement } from '../../../models/reimbursement';
import { Decision } from '../../../models/decision';
import { ReimbursementListService } from '../../../services/reimbursement-list.service';

@Component({
  selector: 'app-decisions',
  templateUrl: './decisions.component.html',
  styleUrls: ['./decisions.component.css']
})
export class DecisionsComponent implements OnInit {
  decisions: Decision[] = DecisionsService.decisions;
  reimbursements: Reimbursement[];
  style: string[] = ['', 'primary', 'success', 'danger'];
  constructor(private decisionService: DecisionsService, private reimbService: ReimbursementListService) { }

  ngOnInit() {
    this.reimbService.getReimbursementsArray().subscribe(reimbs => this.reimbursements = reimbs);
  }

  managerDecision(): void {
    this.decisionService.managerDecision();
  }

  delete(decision): void {
    this.decisionService.deleteDecision(decision);
  }

  createViewable(): Reimbursement[] {
    console.log('[LOG]-----create viewable');
    const reimb: Reimbursement[] = [];
    this.decisions.forEach(d => {
      this.reimbursements.forEach(r => {
        if (r.rId === d.rId) {
          r.rq_statusId = d.rq_statusId;
          reimb.push(r);
        }
      });
    });
    return reimb;
  }
}
