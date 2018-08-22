import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoggedUserService } from './logged-user.service';

@Injectable({
  providedIn: 'root'
})
export class SubmitService {

  constructor(private http: HttpClient, private logged: LoggedUserService) { }

  submit(amount, description, id) {
    const uId = this.logged.getLoggedUser().uId;
    const reimb = {
      uId: uId,
      amount: amount,
      description: description,
      img: null,
      rqTypeId: id
    };
    return this.http.post('http://localhost:8080/reimbursements_project/employee/reimbursements/submit', reimb);
  }
}
