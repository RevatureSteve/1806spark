import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoggeduserService } from './../services/loggeduser.service';
import { Component, OnInit } from '@angular/core';
import { User } from './../models/users';


@Component({
  selector: 'app-update-users-component',
  templateUrl: './update-users-component.component.html',
  styleUrls: ['./update-users-component.component.css']
})
export class UpdateUsersComponentComponent implements OnInit {
  LoggeduserService: User;
  lUser: User;
  constructor(private http: HttpClient, private route: Router, private LoggeduserServices: LoggeduserService) { }

  ngOnInit() {
    console.log('nginit');
  this.lUser = this.LoggeduserServices.getloggeduser();
  }

  updateUser() {
    console.log(this.lUser);
    this.http.post('http://localhost:8080/ErsProject/UpdateUserServlet', this.lUser).subscribe(x => console.log(x));
  }

}
