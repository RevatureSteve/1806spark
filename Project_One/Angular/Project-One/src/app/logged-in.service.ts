import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Users } from './models/Users';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class LoggedInService {
  private static user: Users;

  constructor(private httpClient: HttpClient, private router: Router) { }

  setLoggedInUser(user: Users) {
    LoggedInService.user = user;
    console.log(user);
    console.log(LoggedInService.user);

  }

  getLoggedInUser() {
    console.log(LoggedInService.user);
    return LoggedInService.user;
  }

  logout(): void {
    this.setLoggedInUser(null);
    this.router.navigate(['/login']);
  }

  getUser(email, password): Observable<Users> {

    const user = {
      email: email,
      password: password
    };

    return this.httpClient.post<Users>('http://localhost:8080/ProjectOne/reimbursement/v', user);
  }
}

