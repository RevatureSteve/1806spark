import { User } from './../models/user.model';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user: User;

  constructor(private httpClient: HttpClient, private router: Router) { }

  login(user: User) {
    this.validateUser(user);
  }

  validateUser(user: User): void {
    this.httpClient.post('http://localhost:8080/Project1/login?email=' + user.email + '&password=' + user.password, user)
      .subscribe((resp: any) => {
        this.user = resp;

        if (this.user != null) {
          switch (this.user.posId) {
            case 1:
              this.router.navigateByUrl('/manHome');
              break;
            case 2:
              this.router.navigateByUrl('/empHome');
              break;
            default:
              break;
          }
        } else {
          this.user = {
            uId: 0,
            email: '',
            password: '',
            fname: '',
            lname: '',
            posId: 0
          };
          console.log('user is null try again');
        }

      });
  }

  getAllUsers(): void {

  }

}
