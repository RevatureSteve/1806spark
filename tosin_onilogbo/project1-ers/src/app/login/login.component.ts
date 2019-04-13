import { Component, OnInit } from '@angular/core';
import {DataServiceService} from '../data-service.service';
import { User } from '../userclass';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private data: DataServiceService, public router: Router) { }
  display: String;
  
  ngOnInit() {
  }

  getUsersLogin (){
    console.log('USER: ' + this.data.user.email);
    this.data.getUsersLogin(this.data.user).subscribe(user => {
      if (user) {
        this.data.user=user
        if (user.positionID==2){
          this.router.navigate(['dashboard'])
        } else {
          this.router.navigate(['manager-dashboard'])
        }
      } else {
        console.log("wrong password. try again");
        this.display = "wrong password. try again";
      }
    });
  }

}
