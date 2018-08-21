import { Injectable } from '@angular/core';
import { Users } from './models/users.model';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  private static user: Users;

  constructor() { }

  setCurrentUser(user) {
    CurrentUserService.user = user;
  }

  getCurrentUser() {
    return CurrentUserService.user;
  }
}
