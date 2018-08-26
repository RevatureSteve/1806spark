import { LoggedInService } from '../../logged-in.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {User} from '../../models/user';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  user: User;
  choice = 1;

  constructor(private logged: LoggedInService, private route: ActivatedRoute) {
   }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
  }

  getPending() {
    this.choice = 1;
  }

  getResolved() {
    this.choice = 2;
  }

}
