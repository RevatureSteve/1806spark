import { Injectable } from '@angular/core';
import { Decision } from '../models/decision';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DecisionsService {
  static decisions: Decision[] = [];
  constructor(private http: HttpClient) { }

  addDecisions(decision: Decision): number {
    for (let i = 0; i < DecisionsService.decisions.length; i++) {
      if (DecisionsService.decisions[i].rId === decision.rId) {
        DecisionsService.decisions[i].rq_statusId = decision.rq_statusId;
        return 2;
      }
    }
    DecisionsService.decisions.push(decision);
    console.log(DecisionsService.decisions);
    return 1;
  }

  managerDecision(): void {
    this.http.put('http://localhost:8080/Reimbursement/reimbursement/update', DecisionsService.decisions);
  }
}
