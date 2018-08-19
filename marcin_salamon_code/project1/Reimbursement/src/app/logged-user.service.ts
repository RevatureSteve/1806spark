import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

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
}
