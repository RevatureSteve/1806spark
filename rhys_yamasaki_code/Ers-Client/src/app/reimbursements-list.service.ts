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

  // getReimbursementsArray(): Observable<Reimbursement[]> {
  //   return this.reimbursement;
  // }

}
