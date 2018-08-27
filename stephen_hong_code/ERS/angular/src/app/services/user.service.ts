import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';


const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  subscribers: BehaviorSubject<User> = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient) { }

  registerUser(user: User): Observable<User> {
    console.log(`Registering user: ${user.username}`);
    let json = JSON.stringify(user);
    return this.http.post<User>(environment.apiUrl + 'register', json, HTTP_OPTIONS);
  }

  loginUser(creds: string[]): Observable<User> {
    console.log(`Validating user: ${creds[0]}`);
    let json = JSON.stringify(creds);
    return this.http.post<User>(environment.apiUrl + 'login', json, HTTP_OPTIONS);
  }

  getUserById(id: number) {
    console.log('In UserService.getUserById()');
    const json = JSON.stringify(id);
    return this.http.post<User>(environment.apiUrl + 'userForReimbursement.loadinfo', json, HTTP_OPTIONS);
  }

  getAllUsers() {
    console.log('In UserService.getAllUsers()');
    const json = '';
    return this.http.post<User[]>(environment.apiUrl + 'allUsers.loadinfo', json, HTTP_OPTIONS);
  }

  isUsernameAvailable(usr: string) {
    const json = JSON.stringify(usr);
    return this.http.post<string>(environment.apiUrl + 'username.validate', json, HTTP_OPTIONS);
  }
}
