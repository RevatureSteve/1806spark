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

  validateUser(user: User) {
    this.httpClient.post<User>('http://localhost:8080/Project1/login', user)
      .subscribe(resp => {
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
            firstname: '',
            lastname: '',
            posId: 0
          };
          console.log('user is null try again');
        }

      });
  }

  currentUser() {
    return this.user;
  }

  // Employee Cases
  updateProfile(user: User) {
    this.httpClient.put<User>('http://localhost:8080/Project1/profile', user).subscribe(resp => {
      this.user = resp;
    });
  }

  // Manager Cases
  getAllUsers() {
    return this.httpClient.get<User[]>('http://localhost:8080/Project1/users');
  }

}
