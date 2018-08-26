import { HttpClient } from '@angular/common/http';
import { User } from './models/user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeListService {

  user: User[];

  constructor(private http: HttpClient) { }

  getAllUsers() {
    return this.http.get<User[]>('http://localhost:8080/Ers-Project-1/employee');
  }

}
