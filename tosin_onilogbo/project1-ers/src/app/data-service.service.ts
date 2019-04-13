import { Injectable } from '@angular/core';
import {HttpClientModule, HttpClient, HttpHeaderResponse, HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from './userclass';
import { Reimbursement } from './reimbursement';

@Injectable({
  providedIn: 'root'
})

export class DataServiceService {
  user = new User();
  reimbursement = new Reimbursement();
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private http: HttpClient) { }
  getUsersLogin(user: User){
    
    return this.http.post<User>('http://localhost:8080/Reimbursement/LoginServlet', user, this.httpOptions)
  }
  
  updateUser(user: User){
    return this.http.put('http://localhost:8080/Reimbursement/UserServlet', user);
  }
  readRequests(){
    return this.http.get<Reimbursement[]>('http://localhost:8080/Reimbursement/RequestServlet')
  }
  readUsers(){
    return this.http.get<User[]>('http://localhost:8080/Reimbursement/UserServlet')
  }
  submitRequest(reimbursement){
    console.log("post")
    return this.http.post<Reimbursement>('http://localhost:8080/Reimbursement/RequestServlet', reimbursement, this.httpOptions)
  }
  updateRequestStatus(statusId){

    return this.http.put('http://localhost:8080/Reimbursement/RequestServlet', statusId)
  }
}
