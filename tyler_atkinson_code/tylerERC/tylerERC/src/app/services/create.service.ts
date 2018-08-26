import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoggedUserService } from './logged-user.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CreateService {

  constructor(private http: HttpClient) { }

  submit(uid, mgruid, amt, description, rqtypeid, rqstatusid): Observable<number> {
    console.log('CreateService');
    
    const reimb = {
      "uid": uid,
      "mgruid": mgruid,
      "amt":amt,
      "description": description,
      "rqtypeid": Number.parseInt(rqtypeid),
      "rqstatusid": 1
    };
    console.log(reimb);
    return this.http.post<number>('http://localhost:8080/expenseProject/AddReimbursementServlet', reimb);
  }
}