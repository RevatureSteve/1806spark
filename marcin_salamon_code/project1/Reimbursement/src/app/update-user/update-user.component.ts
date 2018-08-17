import { Component, OnInit } from '@angular/core';
import { UpdateService } from '../update.service';
import { User } from '../user';
import { LoggedUserService } from '../logged-user.service';

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
  }

  updateUser(email, password, fname, lname) {
    console.log(email + password + fname + lname);
    this.update.updateUser(email, password, fname, lname).subscribe(user => this.user = user);
  }
}
