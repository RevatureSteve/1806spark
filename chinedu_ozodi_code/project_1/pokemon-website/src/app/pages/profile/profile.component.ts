import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  edit = false;
  newPassword = '';

  constructor(
    private login: LoginService,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.login.checkSession();
  }

  toggleEdit() {
    this.edit = !this.edit;
  }

  save() {
    console.log( 'password: ' + this.login.currentUser.password);
    this.toggleEdit();
    if (this.newPassword !== '') {
      this.login.currentUser.password = this.newPassword;
    }
    console.log( 'password: ' + this.login.currentUser.password);
    this.userService.updateTrainer(this.login.currentTrainer).subscribe();
    this.userService.updateUser(this.login.currentUser).subscribe(complete => {
      this.login.saveUserCookie(this.login.currentUser);
    });
    this.login.currentUser.password = null;
  }

}
