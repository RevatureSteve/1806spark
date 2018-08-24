import { Injectable } from '@angular/core';
import { User } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class LoggedonService {

  private static user: User;

  constructor() { }

  setloggedon(user) {
    LoggedonService.user = user;
    
    console.log(user + "singleton");
    console.log(LoggedonService.user + "singleton 2nd");
    console.log(user + "singleton");
    console.log(LoggedonService.user + "singleton 2nd");
    
    console.log(localStorage.getItem('user'))
  }

  getloggedon() {
    console.log(localStorage.getItem('user'))
    console.log(LoggedonService.user);
    return LoggedonService.user;
    
  }
} 
