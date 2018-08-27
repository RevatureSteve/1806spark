import { LoggedInService } from './../../logged-in.service';
import { Users } from './../../models/Users';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  user: Users;

  constructor(private loggedInService: LoggedInService) { }

  ngOnInit() {
    this.user = this.loggedInService.getLoggedInUser();
  }

}
