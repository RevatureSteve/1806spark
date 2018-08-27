import { Reimbursement } from './models/Reimbursement';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UpdateReimbService {
  private static reimb: Reimbursement;
  user: Users;

  constructor(private httpClient: HttpClient) { }

  updateReimb(r_Id, mgr_U_Id, rq_Status_Id): Observable<Reimbursement> {

    const reimb = {
      r_Id: r_Id,
      mgr_U_Id: mgr_U_Id,
      rq_Status_Id: rq_Status_Id
    };
    return this.httpClient.post<Reimbursement>('http://localhost:8080/ProjectOne/managerOptions', reimb);
  }
}
