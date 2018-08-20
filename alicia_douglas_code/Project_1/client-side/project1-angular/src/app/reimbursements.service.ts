import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reimbursements } from './models/reimbursements.model';


@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  reimbursements: Observable<Reimbursements[]>;

  url = 'http://localhost:8080/reimbursement/reimbursement';

  constructor(private httpClient: HttpClient) { }

  getAllReimbursements(): void {
    this.reimbursements = this.httpClient.get<Reimbursements[]>(this.url);
  }

  getReimbursementsArray(): Observable<Reimbursements[]> {
    return this.reimbursements;
  }
}
