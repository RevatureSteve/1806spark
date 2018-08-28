import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class EveryService {

  private EmpesUrl = 'api/Empes'; // URL to web api

  constructor(private http: HttpClient) { }

  getEmps(): Observable<Emp[]> {
    return this.http.get<Emp[]>(this.EmpesUrl);
  }

  /** GET by id. Will 404 if id not found */
  getEmp(id: number): Observable<Emp> {
    const url = `${this.EmpesUrl}/${id}`;
    return this.http.get<Emp>(url);
  }

  /** PUT: update the server */
  updateEmp (Emp: Emp): Observable<any> {
    return this.http.put(this.EmpesUrl, Emp, httpOptions);
  }

  /** POST: add to the server */
  addEmp (Emp: Emp): Observable<Emp> {
    return this.http.post<Emp>(this.EmpesUrl, Emp, httpOptions);
  }
}
