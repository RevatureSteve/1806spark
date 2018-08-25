

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from './Users';
import { Reimbursement } from './models/reimbursement';
import { RouterModule, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
 static user: Users;
  constructor(private router : Router, private httpClient: HttpClient) { }

//Login
    loginUser(email, password) {
        console.log('Success');
       return this.httpClient.get<Users>('http://localhost:8080/ERS/LoginServlet');
        
   
       
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
//Setting the current logged user.
setLoggedInUser(user) {
    UsersService.user = user;
  }
//Logging out the current logged in user.
  logout(): void {
    this.setLoggedInUser(null);
    this.router.navigate(['/login']);
  }

  //Get the current logged in user.
  currentLoggedUser() {
      return UsersService.user;
     
  }
}