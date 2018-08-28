import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.user = {
      uId: this.userService.currentUser().uId,
      email: this.userService.currentUser().email,
      password: this.userService.currentUser().password,
      firstname: this.userService.currentUser().firstname,
      lastname: this.userService.currentUser().lastname,
      posId: this.userService.currentUser().posId
    };
  }

  updateProfile() {
    this.userService.updateProfile(this.user);
  }



}
