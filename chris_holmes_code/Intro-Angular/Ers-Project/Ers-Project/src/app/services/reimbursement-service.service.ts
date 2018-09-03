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
  updateReimbursements(data: Reimbursements[]) {
    console.log('updating ' + data[0].description);
    return this.http.put('http://localhost:8080/ErsProject/UpdateRstatusServlet', data, this.httpOptions);
  }

}
