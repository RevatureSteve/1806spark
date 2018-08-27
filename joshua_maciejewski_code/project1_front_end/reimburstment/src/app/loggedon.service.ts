import { Injectable } from '@angular/core';
import { User } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class LoggedonService {

  private static user: User;

  user=JSON.parse(localStorage.getItem('user'));

  constructor() { }

  setloggedon(user) {
    
    
    //user=JSON.parse(localStorage.getItem('user'));

    console.log(user)

  }

  getloggedon() {

    return this.user;
    
  }
} 
