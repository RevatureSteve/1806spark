import { Users } from './models/users.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private httpClient: HttpClient) { }

  login (email, password) {
    const user = {
      email: email,
      pass_word: password
    };
    console.log(user);

    return this.httpClient.post<Users>('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/login', user);
  }

  getAllUsers() {
    return this.httpClient.get<Users[]>('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/users');
  }

  updateUser(u_id, email, fname, lname) {
    const user = {
      u_id: u_id,
      email: email,
      fname: fname,
      lname: lname
    };

    return this.httpClient.put<Users>('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/users', user);
  }

  createUser (user) {
    return this.httpClient.post('http://18.188.229.73:8080/Project1-0.0.1-SNAPSHOT/users', user);
  }
}
