import { Injectable } from '@angular/core';
import { Observable } from '../node_modules/rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';


@Injectable({
  providedIn: 'root',
})
export class LoginService {



  constructor(private httpClient: HttpClient) { }

//  getUser(email, password) {
//    this.httpClient.post('http://localhost:8080/Ers-Project-1/login',
//   {email: email,
//   password: password
//   }).subscribe(
//     res => {
//       this.user = res.value.user;
//     }
//   )

// }
}
