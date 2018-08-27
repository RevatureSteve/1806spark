import { CurrentUserService } from './../services/current-user.service';
import { Users } from './../models/users';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

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
