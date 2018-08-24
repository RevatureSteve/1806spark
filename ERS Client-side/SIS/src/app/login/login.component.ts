import { HttpClient } from '@angular/common/http';
import { Users } from './../models/users';
import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
inputUser: Users;
  
  constructor(private httpClient: HttpClient) { }

  ngOnInit() {

    this.inputUser = {
      uId: 0,
      fName: "",
      lName: "",
      email: "", 
      password: "",
      positionId: 0,
    }
  }

// login() {
// this.validateUser(this.inputUser);
// }
// validateUser(user:Users) {
//   this.httpClient.post("http://localhost:8080/ERS/login",user).subscribe(

//     sucess => {
//       console.log("Successful login.")
//     },
//     err => {
//       alert("Failed login.")
//     }
//   )


}
