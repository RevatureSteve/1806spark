import { Component, OnInit } from '@angular/core';
import { User} from '../model/user';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  InputUser : User;
  constructor(private httpClient: HttpClient) { }

  ngOnInit() {


    this.InputUser = {
      userId : 0,
      username: "",
      password: "",
      userTasks: null
    }
  }
loging() {
  console.log(this.InputUser);
  this.loginUser(this.InputUser);
}

loginUser(user: User) {
this.httpClient.post("http://localhost:8080/ToDoList-Restful-API/login", user).subscribe(
  user => console.log(user), err => console.log("login failed")

)
}
}
