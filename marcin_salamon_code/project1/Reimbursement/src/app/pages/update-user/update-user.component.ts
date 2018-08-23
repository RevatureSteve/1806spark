import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UpdateService } from '../../services/update.service';
import { LoggedUserService } from '../../services/logged-user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  user: User;
  constructor(private update: UpdateService, private logged: LoggedUserService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedUser();
    console.log(this.user);
  }

  updateUser(password, fname, lname) {
    console.log(this.user.email + password + fname + lname);
    console.log(this.user);
    this.update.updateUser(this.user, password, fname, lname).subscribe(user => this.user = user, user => console.log(user));
  }
}
