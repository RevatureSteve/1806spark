import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reimbursements } from '../models/Reimbursements';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementServiceService {
  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  getReimbursements() {
    return this.http.get<Reimbursements[]>('http://localhost:8080/ErsProject/ViewAllReimbursements', this.httpOptions);
  }

}
