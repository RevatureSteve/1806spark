import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from '../models/reimbursement';

@Injectable({
    providedIn: 'root'
})

export class ReimbursementListService {
    reimbursements: Observable<Reimbursement[]>;
    constructor(private http: HttpClient) {}

    getPendingReimbursementsById(id): void {

    }

    getReimbursementsByUserId(id): void {
        this.reimbursements = this. http.get<Reimbursement[]>('http://localhost:8080/expenseProject/AllReimbursementsServlet?id=${id}')
    }

    getReimbursementsArray(): Observable<Reimbursement[]> {
        return this.reimbursements;
    }

    getReimbursement(rId): Observable<Reimbursement> {
        return this.http.get<Reimbursement>('http://localhost:8080/expenseProject/OneReimbursemet/${rId}');
    }

    getAllReimbursements(): void{
        this.reimbursements = this.http.get<Reimbursement[]>('http://localhost:8080/expenseProject/AllReimbursementsServlet?id=${id}')
    }
}