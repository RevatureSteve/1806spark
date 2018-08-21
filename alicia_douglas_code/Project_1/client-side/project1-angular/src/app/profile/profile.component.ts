
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users.model';
import { CurrentUserService } from '../current-user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: Users;

  constructor(private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    console.log(this.user);
    // this.setPage(this.user);
  }

  // setPage(user) {
  //   document.getElementById('fname').innerText = user.fname;
  // }

}
