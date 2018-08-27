import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) { }

  validateUser(email, password): Observable<User> {
    const user = {
      email: email,
      password: password
    };
    console.log(user);
    return this.http.post<User>('http://18.223.123.204:8080/Reimbursement-0.0.1-SNAPSHOT/login', user);
  }
}
