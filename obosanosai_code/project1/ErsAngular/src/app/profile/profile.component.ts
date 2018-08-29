
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users.model';
import { CurrentUserService } from '../current-user.service';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: Users;
  posId;

  constructor(private currentUser: CurrentUserService, private userService: UsersService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    console.log(this.user);
    this.posId = this.user.pos_id;
  }


  updateUser(email, fname, lname) {
    const id = this.user.u_id;
    this.userService.updateUser(id, email, fname, lname)
      .subscribe(user => this.user = user);
    this.currentUser.setCurrentUser(this.user);
  }

}
