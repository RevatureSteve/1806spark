import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  // import our Users model
  user: Users;

  // when the object is created this constructor initialized and when the object is created on the page NgOnInIt is called
  constructor(private currentUser: CurrentUserService) { }

  ngOnInit() {
    // here I assign my currentUser object to the user object of this scope in order to use this in this components HTML file
    this.user = this.currentUser.getCurrentUser();
    console.log(this.user);
  }

}
