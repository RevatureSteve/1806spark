import { LoggedInService } from './logged-in.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from './models/reimbursement';
import { Injectable } from '@angular/core';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsListService {

  user: User;
  reimbursement: Reimbursement[];


  constructor(private http: HttpClient, logged: LoggedInService) { }


  getAllReimbursements() {
    console.log('Meow meow');
    return this.http.get<Reimbursement[]>('http://localhost:8080/Ers-Project-1/manager/reimbursements');
  }

  getResolvedReimbursements() {
    return this.http.get<Reimbursement[]>('http://localhost:8080/Ers-Project-1/reimbursements/resolved');
  }

  resolveReimbursement(userId, r_id, rq_status_id) {
    const reim = {
      user_id: userId,
      r_id: r_id,
      rq_status_id: rq_status_id
    };
    console.log(reim);
    return this.http.put('http://localhost:8080/Ers-Project-1/reimbursements/id', reim);
  }

  getReimbursementsById(id) {
    return this.http.get<Reimbursement[]>(`http://localhost:8080/Ers-Project-1/reimbursements/id?user_id=${id}`);
  }

}
