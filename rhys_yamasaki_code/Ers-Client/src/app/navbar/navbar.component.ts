import { LoggedInService } from './../logged-in.service';
import { User } from './../user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  user: User;
  constructor(private logged: LoggedInService) { }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
  }

}
