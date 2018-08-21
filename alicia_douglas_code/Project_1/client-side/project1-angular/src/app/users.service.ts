import { Users } from './models/users.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private httpClient: HttpClient) { }

  getUser (email, password) {
    const user = {
      email: email,
      password: password
    };
    console.log(user);

    return this.httpClient.post<Users>('http://localhost:8080/reimbursement/login', user);
  }
}
