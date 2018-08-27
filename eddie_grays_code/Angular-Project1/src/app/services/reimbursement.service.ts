import { Reimbursement } from './../models/reimbursement.model';
import { User } from './../models/user.model';
import { UserService } from './user.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  user: User;
  reimbursement: Reimbursement[];



  constructor(private httpClient: HttpClient, private userService: UserService) { }

  // Employee Cases
  submitReimbursementRequest(empId: number, amount: number, description: string, imageUrl: string, reqTypeId: number): void {

  }
  viewAllPendingReimbursementsById(uId: number) {
    return this.httpClient.get('http://localhost:8080/Project1/userPending?uId=1');
  }

  viewAllResolvedReimbursementsById(uId: number) {
    return this.httpClient.get('http://localhost:8080/Project1/userResolved?uId=1');
  }

  // Manager Cases
  viewAllPendingReimbursements(): void {

  }

  viewAllResolvedReimbursements(): void {

  }

  viewAllReimbursementsById(uId: number): void {

  }


}
