import { CurrentUserService } from './current-user.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reimbursements } from './models/reimbursements.model';


@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  public reimb;

  // reimbursements: Observable<Reimbursements[]>;

  constructor(private httpClient: HttpClient, private currentUser: CurrentUserService) { }

  getAllReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/reimbursement');
  }

  // getReimbursementsArray(): Observable<Reimbursements[]> {
  //   return this.reimbursements;
  // }

  getReimbursementById(id) {
    return this.httpClient.get<Reimbursements[]>('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/reimbursement/id'
     + '?userId=' + id);
  }

  getPendingReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/pending');
  }

  getPendingReimbursemetsById(id) {
    return this.httpClient.get<Reimbursements[]>(`http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/pending/id?userId=${id}`);
  }

  getResolvedReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/resolved');
  }

  getResolvedReimbursemetsById(id) {
    return this.httpClient.get<Reimbursements[]>(`http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/resolved/id?userId=${id}`);
  }

  createNewReimbursement(amt, desc, type) {
    const reimb = {
      u_id: 1,
      amt: amt,
      desc: desc,
      type: type
    };

    console.log(reimb);

    this.reimb = reimb;

    // console.log('after post statement');
  }

  updateReimbursement(rId, mgrId, status) {
    const update = {
      rId: rId,
      mgrId: mgrId,
      status: status
    };

    console.log(update);

    return this.httpClient.put<Reimbursements>('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/reimbursement', update);

  }

}
