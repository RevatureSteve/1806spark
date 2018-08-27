import { RequestStatus } from './../request_status';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Reimbursement } from './../models/reimbursement';
import { Injectable, Input } from '@angular/core';
import { Observable } from 'rxjs';

const reimbUrl = 'http://localhost:8080/PokemonWebsiteAPI/reimbursement';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private http: HttpClient) { }

  createReimbursement(reimb: Reimbursement): Observable<RequestStatus> {
    return this.http.post<RequestStatus>(reimbUrl, reimb, httpOptions);
  }

  getReimbursementsByUserId(userId: number): Observable<Reimbursement[]> {
    const fullUrl = `${reimbUrl}?userId=${userId}`;
    return this.http.get<Reimbursement[]>(fullUrl);
  }

  updateReimbursement(reimb: Reimbursement): Observable<RequestStatus> {
    return this.http.put<RequestStatus>(reimbUrl, reimb, httpOptions);
  }
}
