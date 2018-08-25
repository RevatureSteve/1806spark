

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from './Users';
import { Reimbursement } from './models/reimbursement';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
user: Users;
  constructor(private httpClient: HttpClient) { }

//Login
    loginUser(email, password) {
        console.log('Success');
   return this.httpClient.get('http://localhost:8080/ERS/LoginServlet');
       
    }
//Get all users.
getAllUsers() {
    return this.httpClient.get('http://localhost:8080/ERS/GetAllEmployeesServlet');
}

// Get all reimbursements.

getAllReimbursements() {
    console.log("Getting all reimbursements");
   return this.httpClient.get<Reimbursement[]>('http://localhost:8080/ERS/AllReimbursementsServlet');
   
   
        
  
    

}


//Add emloyee.

addNewEmployee() {
    return this.httpClient.get('http://localhost:8080/ERS/');
}

//Add reimbursement.
addNewReimbursement() {
    return this.httpClient.get('http://localhost:8080/ERS/');
}

}
