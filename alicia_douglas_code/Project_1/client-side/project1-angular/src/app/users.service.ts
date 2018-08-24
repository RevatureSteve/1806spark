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


    // return this.httpClient.post<Users>(`http://localhost:8080/reimbursement/login?email=${email}&password=${password}`, user);

    return this.httpClient.post<Users>('http://localhost:8080/reimbursement/login', user);
  }

  getAllUsers() {
    return this.httpClient.get<Users[]>('http://localhost:8080/reimbursement/users');
  }

  updateUser(u_id, email, fname, lname) {
    const user = {
      u_id: u_id,
      email: email,
      fname: fname,
      lname: lname
    };

    return this.httpClient.post<Users>('http://localhost:8080/reimbursement/users', user);
  }
}
