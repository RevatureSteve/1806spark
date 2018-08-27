import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {LoggedonService} from '../loggedon.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  input : User
  verifiedUser : User

  constructor(private httpClient: HttpClient, private loggedon: LoggedonService, private router: Router) { }

  ngOnInit() {
    localStorage.clear();
    this.verifiedUser = null;
    this.input = {
      u_id: 0,
      email: '',
      password: '',
      fname: null,
      lname: null,
      posId: 0,
      posType: null

    };
  }

login() {
  this.loginUser(this.input);
}

loginUser(user: User): void {
  console.log('service: loginuser????')
  this.httpClient.post(`http://localhost:8080/project1/login`,
    user).subscribe(
      success => {
        console.log('log success');
        console.dir(success);
        localStorage.setItem('user', JSON.stringify(success));
        this.setUser();
       
       
        // console.dir(user[1])


      },
      err => alert('login was a failure')
    );
}

setUser() {
  
  
  
  this.verifiedUser = JSON.parse(localStorage.getItem('user'));
  console.log(this.verifiedUser);
  this.loggedon.setloggedon(this.verifiedUser);
  if(this.verifiedUser.posId ===1) {
    this.router.navigate(['employeehome']);
  } else if (this.verifiedUser.posId ===2) { 
    this.router.navigate(['managerhome']);
  } else {
    // alert('incorrect email or password!');
    this.router.navigate(['login']);
 
  }


}

}