import { Users } from './models/Users';
import { Reimbursement } from './models/Reimbursement';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class DataService {

    reimbursement: Reimbursement[];

    constructor(private http: HttpClient) { }
    // urls setted for each specific class
    // Reimbursement Servlet
    getReimbs() {
            // <Reimbursement>, setting the return type as an reimbursement
        return this.http.get<Reimbursement[]>('http://localhost:8080/ProjectOne/reimbursement');
    }
    // Pending Reimbursement Servlet
    getPendReimb() {
        return this.http.get<Reimbursement[]>('http://localhost:8080/ProjectOne/reimbursement/pending');
    }
    // Approved Reimbursement Servlet
    getApprovedReimb() {
        return this.http.get<Reimbursement[]>('http://localhost:8080/ProjectOne/reimbursement/approved');
    }
    // Denied Reimbursement Servlet
    getDeniedReimb() {
        return this.http.get<Reimbursement[]>('http://localhost:8080/ProjectOne/reimbursement/denied');
    }
    // GetUserByEmail Servlet
    getUser() {
        return this.http.get<Users>('http://localhost:8080/ProjectOne/user/email');
    }
}
