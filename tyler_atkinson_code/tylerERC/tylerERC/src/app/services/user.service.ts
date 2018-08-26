import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private httpClient: HttpClient) { }


// getRequestById(id: number): void {
//   this.httpClient.get ('http://localhost:8080/expenseProject/OneReimbursement/${id}')
//   .subscribe(
//     (succ) => {
//       this.oneRequest = succ;
//       console.log(succ);
//     },
//     (err) => {
//       alert('failed to retreive request id ' + id);
//     }
//   );
// }
}