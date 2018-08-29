import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Reimbursement } from './reimbursement';
import { LoginServiceService } from './login-service.service';
import { Observable } from 'rxjs';
import { User } from './user';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })}


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  request: Reimbursement;
  
  constructor(private http: HttpClient,private loginService: LoginServiceService) { }


  createRequest(request:Reimbursement):Observable<Reimbursement>{

    return this.http.post<Reimbursement>("http://18.223.33.87:8080/ERS_Proj1-0.0.1-SNAPSHOT/reimbursement", request, HTTP_OPTIONS);
  }



  getAllRequestsById(id:number):Observable<Reimbursement[]>{
    return this.http.get<Reimbursement[]>("http://18.223.33.87:8080/ERS_Proj1-0.0.1-SNAPSHOT/reimbursement/id?id=" +id, HTTP_OPTIONS);
  }

  getAllRequestByStatusId(id:number,status:string):Observable<Reimbursement[]>{
    return this.http.get<Reimbursement[]>("http://18.223.33.87:8080/ERS_Proj1-0.0.1-SNAPSHOT/reimbursement/id/status?userId=" +id +"&status="+status, HTTP_OPTIONS);
  }

  updateName(employee:User):Observable<User>{
    return this.http.post<User>("http://18.223.33.87:8080/ERS_Proj1-0.0.1-SNAPSHOT/employee/id", employee, HTTP_OPTIONS);
  }

  updatePassword(employee:User):Observable<User>{
    return this.http.post<User>("http://18.223.33.87:8080/ERS_Proj1-0.0.1-SNAPSHOT/employee/id/password", employee, HTTP_OPTIONS);
  }
}
