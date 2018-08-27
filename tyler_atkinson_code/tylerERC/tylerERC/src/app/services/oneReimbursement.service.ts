import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Reimbursement } from '../models/reimbursement';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class ReimbursementListService {


    reimbursements: Reimbursement[];
    constructor(private httpClient: HttpClient) {}



    getReimbursementByUid(rid): Observable <Reimbursement[]> {
        return this.httpClient.get<Reimbursement[]>('http://localhost:8080/expenseProject/OneReimbursement?byId=' + rid);
    }


}