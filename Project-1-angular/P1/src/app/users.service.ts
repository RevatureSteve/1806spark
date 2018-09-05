import { Users } from './models/users.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private httpClient: HttpClient) { }

  login (email, password): Observable<Users> {
    const user = {
      email: email,
      pass_word: password
    };
    console.log(user);

    return this.httpClient.post<Users>('http://localhost:8080/ERS/login', user);
  }

  getAllUsers() {
    return this.httpClient.get<Users[]>('http://localhost:8080/ERS/users');
  }

  updateUser(u_id, email, fname, lname) {
    const user = {
      u_id: u_id,
      email: email,
      fname: fname,
      lname: lname
    };

    return this.httpClient.put<Users>('http://localhost:8080/ERS/users', user);
  }

  createUser (user) {
    return this.httpClient.post('http://localhost:8080/ERS/users', user);
  }
}
