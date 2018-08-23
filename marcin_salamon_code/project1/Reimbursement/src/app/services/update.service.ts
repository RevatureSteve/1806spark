import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { LoggedUserService } from './logged-user.service';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {
  constructor(private http: HttpClient) { }

  updateUser(logged, password, fname, lname): Observable<User> {
    if (password === '') {
      password = logged.password;
    }
    if (fname === '') {
      fname = logged.fname;
    }
    if (lname === '') {
      lname = logged.lname;
    }

    const user = {
      uId: logged.uId,
      email: logged.email,
      password: password,
      fname: fname,
      lname: lname,
      positionId: logged.positionId,
      position: logged.position
    };
    console.log(user);
    return this.http.post<User>('http://localhost:8080/reimbursements_project/employee/update', user);
  }
}
