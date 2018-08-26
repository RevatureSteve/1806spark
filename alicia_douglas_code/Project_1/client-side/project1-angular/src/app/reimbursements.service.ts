import { CurrentUserService } from './current-user.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reimbursements } from './models/reimbursements.model';


@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  // reimbursements: Observable<Reimbursements[]>;

  constructor(private httpClient: HttpClient, private currentUser: CurrentUserService) { }

  getAllReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://18.219.98.243:8080/reimbursement-0.0.1-SNAPSHOT/reimbursement');
  }

  // getReimbursementsArray(): Observable<Reimbursements[]> {
  //   return this.reimbursements;
  // }

  getReimbursementById(id) {
    return this.httpClient.get<Reimbursements[]>('http://18.219.98.243:8080/reimbursement-0.0.1-SNAPSHOT/reimbursement/id'
     + '?userId=' + id);
  }

  getPendingReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://18.219.98.243:8080/reimbursement-0.0.1-SNAPSHOT/pending');
  }

  getPendingReimbursemetsById(id) {
    return this.httpClient.get<Reimbursements[]>(`http://18.219.98.243:8080/reimbursement-0.0.1-SNAPSHOT/pending/id?userId=${id}`);
  }

  getResolvedReimbursements() {
    return this.httpClient.get<Reimbursements[]>('http://18.219.98.243:8080/reimbursement-0.0.1-SNAPSHOT/resolved');
  }

  getResolvedReimbursemetsById(id) {
    return this.httpClient.get<Reimbursements[]>(`http://18.219.98.243:8080/reimbursement-0.0.1-SNAPSHOT/resolved/id?userId=${id}`);
  }

  createNewReimbursement(amt, desc, type, img) {
    const reimb = {
      u_id: this.currentUser.getCurrentUser().u_id,
      amt: amt,
      desc: desc,
      type: type
    };

    console.log(reimb);

    return this.httpClient.post<Reimbursements>('http://18.219.98.243:8080/reimbursement-0.0.1-SNAPSHOT/reimbursement', reimb);

    // console.log('after post statement');
  }

  updateReimbursement(rId, mgrId, status) {
    const update = {
      rId: rId,
      mgrId: mgrId,
      status: status
    };

    console.log(update);

    return this.httpClient.put<Reimbursements>('http://18.219.98.243:8080/reimbursement-0.0.1-SNAPSHOT/reimbursement', update);

  }

}
