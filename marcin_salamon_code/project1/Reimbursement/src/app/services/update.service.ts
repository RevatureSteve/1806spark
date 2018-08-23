import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {
  logged: User;
  constructor(private http: HttpClient) { }

  updateUser(email, password, fname, lname): Observable<User> {
    if (email === '') {
      email = this.logged.email;
    }
    if (password === '') {
      password = this.logged.password;
    }
    if (fname === '') {
      fname = this.logged.fname;
    }
    if (lname === '') {
      lname = this.logged.lname;
    }

    const user = {
      uId: this.logged.uId,
      email: email,
      password: password,
      fname: fname,
      lname: lname,
      positionId: this.logged.positionId,
      position: this.logged.position
    };
    console.log(user);
    return this.http.post<User>('http://localhost:8080/reimbursements_project/employee/update', user);
  }
}
