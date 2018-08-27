import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Reimbursement } from '../models/reimbursement';
import { User } from '../models/user';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  userReimbursements: BehaviorSubject<Reimbursement[]> = new BehaviorSubject<Reimbursement[]>(null);
  allReimbursements: BehaviorSubject<Reimbursement[]> = new BehaviorSubject<Reimbursement[]>(null);

  constructor(private http: HttpClient, private router: Router) { }

  getReimbursementsForUser(user: User) {
    console.log('In ReimbursementService.getReimbursementsForUser()');
    const json = JSON.stringify(user);
    this.http.post<Reimbursement[]>(environment.apiUrl + 'landing.loadinfo', json, HTTP_OPTIONS).subscribe(reimbs => {
      this.userReimbursements.next(reimbs);
    });
  }

  getAllReimbursements() {
    console.log('In ReimbursementService.getAllReimbursements()');
    let json = '';
    this.http.post<Reimbursement[]>(environment.apiUrl + 'allReimbs.loadinfo', json, HTTP_OPTIONS).subscribe(reimbs => {
      this.allReimbursements.next(reimbs);
    });
    this.router.navigate(['landing']);
  }

  createReimbursement(reimb: Reimbursement) {
    console.log('In ReimbursementService.createReimbursement()');
    const json = JSON.stringify(reimb);
    this.http.post<Reimbursement>(environment.apiUrl + 'createReimbursement', json, HTTP_OPTIONS).subscribe(r => {
      const u: User = JSON.parse(localStorage.getItem('user'));
      this.getReimbursementsForUser(u);
      this.getAllReimbursements();
    });
  }

  updateReimbursement(reimb: Reimbursement) {
    console.log('In ReimbursementService.updateReimbursement()');
    const json = JSON.stringify(reimb);
    this.http.post<Reimbursement>(environment.apiUrl + 'updateReimbursement', json, HTTP_OPTIONS).subscribe(r => {
      const u: User = JSON.parse(localStorage.getItem('user'));
      this.getReimbursementsForUser(u);
      this.getAllReimbursements();
    });
  }
}
