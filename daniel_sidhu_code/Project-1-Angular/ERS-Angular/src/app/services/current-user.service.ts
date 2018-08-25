import { Injectable } from '@angular/core';
import { Users } from '../models/users';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  private static user: Users;

  constructor() { }

  setCurrentUser(user: Users) {
    CurrentUserService.user = user;
    console.log(user);
    console.log(CurrentUserService.user);
  }

  getCurrentUser() {
    console.log(CurrentUserService.user);
    return CurrentUserService.user;
  }
}
