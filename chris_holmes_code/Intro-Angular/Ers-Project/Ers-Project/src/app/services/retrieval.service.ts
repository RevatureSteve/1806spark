import { Reimbursements } from './../models/Reimbursements';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RetrievalService {
      httpOptions = {
        headers: new HttpHeaders({
          'content-type': 'application/json'
        })
      };
reimbursement: Reimbursements;
  constructor(private http: HttpClient) { }

  sendReimbursement(emp_u_id, amt, description, rq_type_id) {
    const reim = {
    emp_u_id: emp_u_id,
     amt: amt,
     description: description,
     rq_type_id: rq_type_id
   };
   console.log(reim);
    return this.http.post<Reimbursements>('http://localhost:8080/ErsProject/NewReimbursementServlet', reim, this.httpOptions);
}





}
