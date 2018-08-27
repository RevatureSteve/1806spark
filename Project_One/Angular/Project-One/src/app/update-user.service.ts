import { Reimbursement } from './models/Reimbursement';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Users } from './models/Users';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class UpdateUserService {
  private static user: Users;
  reimb: Reimbursement;

  constructor(private httpClient: HttpClient) { }

  updateUser(email, password, fname, lname, u_Id): Observable<Users> {

    const user = {
      email: email,
      password: password,
      fname: fname,
      lname: lname,
      u_Id: u_Id
    };
    return this.httpClient.post<Users>('http://localhost:8080/ProjectOne/user/update', user);
  }
}
