import { RouterModule, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from './models/user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggedInService {

  private static user: User;

  constructor(private httpClient: HttpClient, private router: Router) { }

  setLoggedInUser(us) {
    LoggedInService.user = us;
  }

  getLoggedInUser(): User {
    return LoggedInService.user;
  }


  checkLoggedInUser() {
    if (localStorage.getItem('user') === null) {
      this.router.navigate(['/']);
    }
  }

  logout(): void {
    this.setLoggedInUser(null);
    this.router.navigate(['/login']);
  }
}
