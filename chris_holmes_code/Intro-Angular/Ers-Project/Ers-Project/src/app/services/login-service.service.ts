import { User } from './../models/users';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  private loginUrl = 'http://localhost:8080/ErsProject/login';

  constructor(private http: HttpClient) { }

  getUser(email, password):
    Observable<User> {
    const user = {
      email: email,
      password: password
    };
    return this.http.post<User>(this.loginUrl,
      user, httpOptions
    );
  }
}

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


