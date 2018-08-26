import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoggedUserService } from './logged-user.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubmitService {

  constructor(private http: HttpClient, private logged: LoggedUserService) { }

  submit(amount, description, id): Observable<number> {
    console.log('SubmitService');
    const uId = this.logged.getLoggedUser().uId;
    const reimb = {
      uId: uId,
      amount: amount,
      description: description,
      img: null,
      rqTypeId: id
    };
    console.log(reimb);
    // return this.http.post('http://18.223.123.204:8080/Reimbursement-0.0.1-SNAPSHOT/employee/reimbursements/submit', reimb);
    return this.http.post<number>('http://localhost:8080/Reimbursement/employee/reimbursements/submit', reimb);
  }
}
