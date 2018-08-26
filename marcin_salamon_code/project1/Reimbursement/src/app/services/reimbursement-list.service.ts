import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from '../models/reimbursement';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementListService {
  reimbursements: Observable<Reimbursement[]>;
  constructor(private http: HttpClient) { }

  getPendingReimbursementsById(id): void {
  }

  getReimbursementsByUserId(id): void {
    this.reimbursements =
      this.http.get<Reimbursement[]>(`http://18.223.123.204:8080/Reimbursement-0.0.1-SNAPSHOT/employee/reimbursements?id=${id}`);
  }

  getReimbursementsArray(): Observable<Reimbursement[]> {
    return this.reimbursements;
  }

  getAllReimbursements(): void {
    this.reimbursements = this.http.get<Reimbursement[]>('http://18.223.123.204:8080/Reimbursement-0.0.1-SNAPSHOT/manager');
  }


}
