import { LoggedInService } from './logged-in.service';
import { Users } from './models/Users';
import { Reimbursement } from './models/Reimbursement';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class CreateReimbService {
  private static reimb: Reimbursement;
  user: Users;

  constructor(private httpClient: HttpClient, private router: Router) { }

  getReimb(amt, u_Id, rq_Type_Id, description): Observable<Reimbursement> {

    const reimb = {
      amt: amt,
      emp_U_Id: u_Id,
      rq_Type_Id: rq_Type_Id,
      description: description
    };
    return this.httpClient.post<Reimbursement>('http://localhost:8080/ProjectOne/reimbursement/create', reimb);
  }
}
