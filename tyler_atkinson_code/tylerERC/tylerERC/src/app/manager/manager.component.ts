import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { LoggedUserService } from '../services/logged-user.service';



@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {
  user: User;
  constructor(private logged: LoggedUserService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedUser();
    console.log(this.user);
  }

}
