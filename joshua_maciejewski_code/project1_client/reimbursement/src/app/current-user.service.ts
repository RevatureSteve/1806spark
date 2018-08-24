import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  private static user: User;

  constructor(private httpClient: HttpClient) { }

  setCurrentUser(us) {
    CurrentUserService.user = us;
  }

  getCurrentUser(): User {
    return CurrentUserService.user;
  }
}
