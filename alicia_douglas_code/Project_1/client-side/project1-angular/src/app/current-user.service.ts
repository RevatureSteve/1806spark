import { Injectable } from '@angular/core';
import { Users } from './models/users.model';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  constructor() { }

  setCurrentUser(user: Users) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));
  }
}
