import { CurrentUserService } from './current-user.service';
import { Reimbursement } from './../models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private httpClient: HttpClient, private currentUserService: CurrentUserService) { }

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

  createNewReimbursement(empUserId, amount, description, requestTypeId) {
    const reimb = {
      empUserId: this.currentUserService.getCurrentUser().userId,
      amount: amount,
      description: description,
      requestTypeId: requestTypeId
    };

    console.log(reimb);

    return this.httpClient.post<Reimbursement>('http://localhost:8080/Project1/NewReimburement', reimb);
  }
}
