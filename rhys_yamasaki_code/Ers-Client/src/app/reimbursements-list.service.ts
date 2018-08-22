import { LoggedInService } from './logged-in.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from './reimbursement';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsListService {

  user: User;
  reimbursement: Observable<Reimbursement[]>;


  constructor(private http: HttpClient, logged: LoggedInService) { }


  getAllReimbursements(pending): void {

  }
}
