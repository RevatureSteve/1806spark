import { Component, OnInit } from '@angular/core';
import { LoggedUserService } from '../services/logged-user.service';
import { User } from '../models/user';
import { UserListService } from '../userlistservice.service';

@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit {

employee: User;

  constructor(private logged: LoggedUserService, private userlistservice:UserListService) {
    this.employee = this.logged.getLoggedUser();
   }

  ngOnInit() {

    this.employee = this.logged.getLoggedUser();
    console.log(this.employee)
  }

 myAwesomeUpdate(){
console.log("Sending: " + this.employee);
  this.userlistservice.myawesomeUpdate(this.employee).subscribe((r)=>{});

 }

}
