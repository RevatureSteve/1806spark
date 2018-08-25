import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class DataService {

    constructor(private http: HttpClient) {}
    // urls setted for each specific class
    // Reimbursement Servlet
    getReimbs() {
        return this.http.get('http://localhost:8080/ProjectOne/reimbursement')
    }
    // Pending Reimbursement Servlet
    getPendReimb() {
        return this.http.get('http://localhost:8080/ProjectOne/reimbursement/pending')
    }
    // Approved Reimbursement Servlet
    getApprovedReimb() {
        return this.http.get('http://localhost:8080/ProjectOne/reimbursement/approved')
    }
    // Denied Reimbursement Servlet
    getDeniedReimb() {
        return this.http.get('http://localhost:8080/ProjectOne/reimbursement/denied')
    }
    // GetUserByEmail Servlet
    getUser() {
        return this.http.get('http://localhost:8080/ProjectOne/user/email')
    }
    postReimb() {
        return this.http.get('http://localhost:8080/ProjectOne/reimbursement/create')
    }
}
