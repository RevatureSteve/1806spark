import { Injectable } from '@angular/core';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from './userclass';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  user: User;

  constructor(private http: HttpClient) { }
  getUsersLogin(user: User){
    
    return this.http.post<User>('http://localhost:8080/Reimbursement/login', user)
  }
  updateUser(fname, lname, password){
    const userUpdate = {
      fname: fname,
      lname: lname,
      password: password
    }
    return this.http.put('http://localhost:8080/Reimbursement/UserServlet', userUpdate)
  }
  readRequests(){
    return this.http.get('http://localhost:8080/Reimbursement/RequestServlet')
  }
  submitRequest(amount, description, timeSubmission, requestId){
    const submissions = {
      amount: amount,
      description: description,
      timeSubmission: timeSubmission,
      requestId: requestId
    }
    return this.http.post('http://localhost:8080/Reimbursement/RequestServlet', submissions)
  }
  updateRequestStatus(statusId){
    const status ={
      statusId: statusId 
    } 
    return this.http.put('http://localhost:8080/Reimbursement/RequestServlet', status)
  }
}
