import { CurrentUserService } from './../current-user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private currentUser: CurrentUserService) { }

  ngOnInit() {
  }

  logout() {
    this.currentUser.setCurrentUser(null);
  }

}
