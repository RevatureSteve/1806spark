import { HttpClient } from '@angular/common/http';
import { User } from './models/user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UpdateEmployeeService {

  user: User;

  constructor(private http: HttpClient) { }

  updateEmployeeInfo(userId, password, fname, lname) {
    const update = {
      user_id: userId,
      password: password,
      fname: fname,
      lname: lname
    };

    console.log(update);

    return this.http.put('http://localhost:8080/Ers-Project-1/employee', update);
  }
}
