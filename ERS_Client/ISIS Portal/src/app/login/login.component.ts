import { UsersService } from './../users-service';
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

  
  constructor(private httpClient: HttpClient,
  private service : UsersService) { }

  ngOnInit() {

    this.inputUser = {
      uId: 0,
      firstname: "",
      lastname: "",
      email: "", 
      password: "",
      positionId: 0,
    }

      let obj = this.httpClient.get('http://localhost:8080/ERS/LoginServlet');
      obj.subscribe(() => {
        console.log("Success");
      } )




  }

login() {
console.log(this.inputUser.email);
console.log(this.inputUser.password);
this.validateUser(this.inputUser.email, this.inputUser.password);
}


validateUser(email, password) {
 console.log( this.service.loginUser(email, password));

};


}
