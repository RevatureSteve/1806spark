import { Users } from './../models/users';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  login(email, password) {
    const user = {
      email: email,
      password: password
    };
    console.log('the user info: ' + user);
    return this.httpClient.post<Users>('http://localhost:8080/Project1/Login', user);
  }



}
