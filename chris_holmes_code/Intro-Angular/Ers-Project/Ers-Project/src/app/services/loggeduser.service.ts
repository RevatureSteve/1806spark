import { Injectable } from '@angular/core';
import { User } from '../models/users';

@Injectable({
  providedIn: 'root'
})
export class LoggeduserService {
private static loggeduser: User;
  constructor() { }
  static getloggeduser() {
    return this.loggeduser;
  }
  static setloggeduser(loggeduser) {
   this.loggeduser = loggeduser;
  }
}
