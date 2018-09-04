import { UserService } from './../../service/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputUser: User;
  validUser = null;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.validUser = null;
    this.inputUser = {
      userId: 0,
      username: '',
      password: '',
      userTasks: null
    };
  }

  login() {
    this.loginUser(this.inputUser);
  }

  loginUser(user: User): void {
    console.log('service: loginUser');
    this.httpClient.post(`http://localhost:8085/TodoList-Restful-API/login`,
          user).subscribe(
          succ => {
            console.log('login successful');
            console.dir(succ);
            localStorage.setItem('user', JSON.stringify(succ));
            this.setUser();
          },
          err => alert('failed login')
        );
  }

  setUser() {
    this.validUser = JSON.parse(localStorage.getItem('user'));
  }


}
