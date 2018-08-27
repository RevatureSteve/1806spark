import { User } from './models/user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root',
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  getUser(email, password) {

    const user = {
      email: email,
      password: password
    };
    return this.httpClient.post<User>('http://localhost:8080/Ers-Project-1/login', user);
}
}
