import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoggedUserService {
  private static user: User;
  constructor(private http: HttpClient) { }

  setLoggedUser(u) {
    LoggedUserService.user = u;
  }

  getLoggedUser(): User {
    return LoggedUserService.user;
  }

  logout(): void {
    this.setLoggedUser(null);
  }
}
