import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class DataService {

    constructor(private http: HttpClient) {}
    // urls setted for each specific class
    // "http://localhost:8080/ProjectOne/reimbursement", Reimbursement Servlet
    // "http://localhost:8080/ProjectOne/reimbursement/pending", Pending Reimbursement Servlet
    // "http://localhost:8080/ProjectOne/reimbursement/approved", Approved Reimbursment Servlet
    // "http://localhost:8080/ProjectOne/reimbursement/denied", Denied Reimbursement Servlet
    // "http://localhost:8080/ProjectOne/user/email", GetUserByEmail Servlet
    // "http://localhost:8080/ProjectOne/reimbursement/create", CreateReimbursement Servlet

}
