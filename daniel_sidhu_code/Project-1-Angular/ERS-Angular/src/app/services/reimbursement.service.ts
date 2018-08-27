import { Reimbursement } from './../models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private httpClient: HttpClient) { }

  // here I can get all reimbursements from the servlet
  getAllReimbursements() {
    return this.httpClient.get<Reimbursement[]>('http://localhost:8080/Project1/allReimbursements');
  }
  // here I can get pending reimbursements from the servlet
  getPendingReimbursements() {
    return this.httpClient.get<Reimbursement[]>('http://localhost:8080/Project1/PendingReimbursements');
  }

  // here I can get approved reimbursements from the servlet
  getApprovedReimbursements() {
    return this.httpClient.get<Reimbursement[]>('http://localhost:8080/Project1/ApprovedReimbursements');
  }

  // unfinished code to get prnding reimbursements by ID
  getPendingReimbursementsById(id) {
  //  return this.httpClient.get<Reimbursement[]>();
  }
}
