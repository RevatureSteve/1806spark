import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from '../models/reimbursement';

@Injectable({
    providedIn: 'root'
})

export class ReimbursementListService {


    reimbursements: Reimbursement[];
    constructor(private httpClient: HttpClient) {}




    

    getReimbursement() {
        return this.httpClient.get<Reimbursement[]>('http://localhost:8080/expenseProject/AllReimbursementsServlet'); //'http://18.188.60.42:8080/expenseProject-0.0.1-SNAPSHOT/AllReimbursementsServlet')
    }

    getReimbursementByEmpId(empuid: number){
        return this.httpClient.get<Reimbursement[]>('http://localhost:8080/expenseProject/ReimbursementByUserIdServlet?emp_u_id=' + empuid)
    }

}

