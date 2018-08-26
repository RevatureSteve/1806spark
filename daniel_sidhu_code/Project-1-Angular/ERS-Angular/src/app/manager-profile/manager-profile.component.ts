import { CurrentUserService } from './../services/current-user.service';
import { Users } from './../models/users';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-profile',
  templateUrl: './manager-profile.component.html',
  styleUrls: ['./manager-profile.component.css']
})
export class ManagerProfileComponent implements OnInit {

  user: Users;
  constructor(private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    console.log(this.user);
  }

}
