import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoggedUserService {
  public user: User;
  constructor(private http: HttpClient) { }

  setLoggedUser(u:User) {
    this.user = u;
  }

  getLoggedUser(): User {
    return this.user;
  }

  logout(): void {
    this.setLoggedUser(null);
  }
}
