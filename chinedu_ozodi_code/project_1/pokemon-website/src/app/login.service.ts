import { RequestStatus } from './request_status';
import { User } from './user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private url = 'http://localhost:8080/PokemonWebsiteAPI/User';

  constructor(private http: HttpClient) {
    this.log('Login Service started');
   }

    login(user: User): Observable<RequestStatus> {
      this.log(' login service started');
    return this.http.post<RequestStatus>(this.url, user, httpOptions).pipe(
      catchError(this.handleError<RequestStatus>('login', new RequestStatus()))
    );
  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  log(info: string) {
    console.log('Login Service: ' + info);
  }
}

