import { CurrentUserService } from './current-user.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reimbursements } from './models/reimbursements.model';


@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  constructor(private httpClient: HttpClient, private currentUser: CurrentUserService) { }

  getAllReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://localhost:8080/ERS/reimbursement');
  }

  getReimbursementById(id) {
    return this.httpClient.get<Reimbursements[]>('http://localhost:8080/ERS/reimbursement/id'
     + '?userId=' + id);
  }

  getPendingReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://localhost:8080/ERS/pending');
  }

  getPendingReimbursemetsById(id) {
    return this.httpClient.get<Reimbursements[]>(`http://localhost:8080/ERS/pending/id?userId=${id}`);
  }

  getResolvedReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://localhost:8080/ERS/resolved');
  }

  getResolvedReimbursemetsById(id) {
    return this.httpClient.get<Reimbursements[]>(`http://localhost:8080/ERS/resolved/id?userId=${id}`);
  }

  createNewReimbursement(amt, desc, type, img): Observable<Reimbursements> {
    const reimb = {
      u_id: this.currentUser.getCurrentUser().u_id,
      amt: amt,
      desc: desc,
      type: type
    };

    console.log(reimb);

    return this.httpClient.post<Reimbursements>('http://localhost:8080/ERS/reimbursement', reimb);

    // console.log('after post statement');
  }

  updateReimbursement(rId, mgrId, status): Observable<Reimbursements> {
    const update = {
      rId: rId,
      mgrId: mgrId,
      status: status
    };

    console.log(update);

    return this.httpClient.put<Reimbursements>('http://localhost:8080/ERS/reimbursement', update);

  }

}
