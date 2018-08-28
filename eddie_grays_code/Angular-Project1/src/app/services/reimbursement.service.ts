import { Reimbursement } from './../models/reimbursement.model';
import { User } from './../models/user.model';
import { UserService } from './user.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  reimb: Reimbursement;

  constructor(private httpClient: HttpClient, private userService: UserService) { }

  // Employee Cases
  submitReimbursementRequest(reimb) {
    return this.httpClient.post('http://localhost:8080/Project1/submitReimbursement', reimb);
  }

  viewAllPendingReimbursementsById(uId: number) {
    return this.httpClient.get<Reimbursement[]>('http://localhost:8080/Project1/userPending?uId=' + uId);
  }

  viewAllResolvedReimbursementsById(uId: number) {
    return this.httpClient.get<Reimbursement[]>('http://localhost:8080/Project1/userResolved?uId=' + uId);
  }

  // Manager Cases
  viewAllPendingReimbursements() {
    return this.httpClient.get<Reimbursement[]>('http://localhost:8080/Project1/allPending');
  }

  viewAllResolvedReimbursements() {
    return this.httpClient.get<Reimbursement[]>('http://localhost:8080/Project1/allResolved');
  }

  viewAllReimbursementsById(uId: number) {
    return this.httpClient.get<Reimbursement[]>('http://localhost:8080/Project1/allRequestId?uId=' + uId);
  }

}
