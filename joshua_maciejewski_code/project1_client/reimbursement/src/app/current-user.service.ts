import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggedInService {

  private static user: User;

  constructor(private httpClient: HttpClient) { }

  setLoggedInUser(us) {
    LoggedInService.user = us;
  }

  getLoggedInUser(): User {
    return LoggedInService.user;
  }
}
