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
  user = this.logged.getLoggedUser();
  constructor(private update: UpdateService, private logged: LoggedUserService) { }

  ngOnInit() {
  }

  updateUser(password, fname, lname) {
    console.log(password + fname + lname);

    this.update.updateUser(password, fname, lname).subscribe(user => this.logged.setLoggedUser(user));
  }
}
