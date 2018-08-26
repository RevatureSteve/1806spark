import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { LoggedUserService } from './logged-user.service';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {
  logged: User;
  constructor(private http: HttpClient, private logService: LoggedUserService) { }

  updateUser(password, fname, lname): Observable<User> {
    this.logged = this.logService.getLoggedUser();
    if (!password) {
      password = this.logged.password;
    }
    if (!fname) {
      fname = this.logged.fname;
    }
    if (!lname) {
      lname = this.logged.lname;
    }

    const user = {
      uId: this.logged.uId,
      email: this.logged.email,
      password: password,
      fname: fname,
      lname: lname,
      positionId: this.logged.positionId,
      position: this.logged.position
    };
    console.log(user);
    return this.http.post<User>('http://18.223.123.204:8080/Reimbursement-0.0.1-SNAPSHOT/employee/update', user);
  }
}
