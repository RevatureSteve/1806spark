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
    this.reimbursements =  this.http.get<Reimbursement[]>(`http://localhost:8080/reimbursements_project/employee/reimbursements/pending?id=${id}`);
  }

  getReimbursementsByUserId(id): void {
    this.reimbursements = this.http.get<Reimbursement[]>(`http://localhost:8080/reimbursements_project/employee/reimbursements?id=${id}`);
  }

  getReimbursementsArray(): Observable<Reimbursement[]> {
    return this.reimbursements;
  }

  getReimbursement(rId): Observable<Reimbursement> {
    return this.http.get<Reimbursement>(`http://localhost:8080/reimbursements_project/${rId}`);
  }

  getAllReimbursements(): Observable<Reimbursement[]> {
    return this.http.get<Reimbursement[]>('http://localhost:8080/reimbursements_project/${rId}');
  }
}
