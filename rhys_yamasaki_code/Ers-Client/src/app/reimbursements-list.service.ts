import { LoggedInService } from './logged-in.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from './models/reimbursement';
import { Injectable } from '@angular/core';
import { User } from './models/user';
import { Type } from './models/type';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsListService {

  user: User;
  reimbursement: Reimbursement[];
  type: Type[];


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

  getEmployeePending(id) {
    return this.http.get<Reimbursement[]>(`http://localhost:8080/Ers-Project-1/employee/pending?user_id=${id}`);
  }

  getEmployeeResolved(id) {
    return this.http.get<Reimbursement[]>(`http://localhost:8080/Ers-Project-1/employee/resolved?user_id=${id}`);
  }

  getType() {
    return this.http.get<Type[]>('http://localhost:8080/Ers-Project-1/type');
  }

  submitReimbursement(userId, amount, desc, type) {
   const reim = {
     user_id: userId,
     amount: amount,
     description: desc,
     type_id: type
   };
   return this.http.post('http://localhost:8080/Ers-Project-1/employee/reimbursement/submit', reim);
 }}
