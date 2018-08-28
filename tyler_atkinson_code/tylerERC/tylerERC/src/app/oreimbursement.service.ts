import { Injectable } from '@angular/core';
import { Reimbursement } from './models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OReimbursementService {

  reimbursements: Reimbursement[];
  constructor(private httpClient: HttpClient) {}



  getReimbursementByUid(rid): Observable <Reimbursement[]> {
      return this.httpClient.get<Reimbursement[]>('http://localhost:8080/expenseProject/OneReimbursement?byId=' + rid);
  }

  updateReimbursement(request:Reimbursement):Observable <Reimbursement>{
    return this.httpClient.post<Reimbursement>('http://localhost:8080/expenseProject/ApproveRequest',request);
    }
}