import { User } from './user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root',
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  getUser(email, password): Observable<User> {

    const user = {
      email: email,
      password: password
    };

    return this.httpClient.post<User>('http://localhost:8080/project1/login', user);
  }
}
