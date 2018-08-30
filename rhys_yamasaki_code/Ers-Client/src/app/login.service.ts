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
    return this.httpClient.post<User>('http://18.223.22.153:8080/Ers-Project-1-0.0.1-SNAPSHOT/login', user);
}
}
