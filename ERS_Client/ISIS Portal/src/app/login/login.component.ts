import { UsersService } from './../users-service';
import { HttpClient } from '@angular/common/http';
import { Users } from './../models/users';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
inputUser: Users;
email: string;
password: string;
  
  constructor(private httpClient: HttpClient,
  private service : UsersService,
private router : Router) { }

  ngOnInit() {


  }

login() {
console.log(this.email);
console.log(this.password);
this.validateUser(this.email, this.password);
}

//Validate User.
validateUser(email, password)  {
  console.log(this.email + this.password)
  this.httpClient.post<Users>('http://localhost:8080/ERS/LoginServlet?email=' + this.email + '&password=' + this.password, this.inputUser)
  .subscribe(data  => {
   
    //console.log(data);
    this.inputUser = data;
   let usr =  JSON.stringify(this.inputUser);
    // console.log(usr);
    

    if (this.inputUser != null) {
      console.log("Setting user....." + this.inputUser)
        this.service.setLoggedInUser(this.inputUser);
        this.service.currentLoggedUser();
        if (this.inputUser.positionId== 2) {
        this.router.navigate(['employee']);
        }
        else if (this.inputUser.positionId == 1) {
          this.router.navigate(['manager']);
        }
    }
    else {
      alert("Invalid email or password .")
      this.service.logout();
    }
  
  } )

 

  



}
}
