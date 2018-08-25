import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  employees: Observable<User[]>;
  constructor(private http: HttpClient) {  }

  getUsers(): Observable<User[]> {
    this.employees = this.http.get<User[]>('http://18.223.123.204:8080/Reimbursement-0.0.1-SNAPSHOT/users/employee');
    return this.employees;
  }

  getUsersArray(): Observable<User[]> {
    return this.employees;
  }
}
