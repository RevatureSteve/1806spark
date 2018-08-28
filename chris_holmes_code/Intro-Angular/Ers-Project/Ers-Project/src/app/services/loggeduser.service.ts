import { Injectable } from '@angular/core';
import { User } from '../models/users';

@Injectable({
  providedIn: 'root'
})
export class LoggeduserService {

  constructor() { }
private loggeduser: User;

  getloggeduser() {
    return this.loggeduser;
  }
  setloggeduser(loggeduser) {
   this.loggeduser = loggeduser;
  }
}
