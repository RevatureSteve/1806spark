import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './models/user';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class UserListService {


    users: User[];
    constructor(private httpClient: HttpClient) {}




    

    getUsers() {
        return this.httpClient.get<User[]>('http://localhost:8080/expenseProject/ViewAllUsersServlet'); //'http://18.188.60.42:8080/expenseProject-0.0.1-SNAPSHOT/AllReimbursementsServlet')
    }


    myawesomeUpdate(employee:User):Observable <User> {

        return this.httpClient.post<User>('http://localhost:8080/expenseProject/EditUsersServlet', employee);

    }


}