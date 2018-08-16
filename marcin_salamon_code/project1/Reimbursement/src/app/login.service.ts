import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  validateUser(email, password): Observable<Object>{
    return this.http.post('localhost:8080/reimbursements_project/login', `{'email':'${email}','password':'${password}'`);
  }
}
