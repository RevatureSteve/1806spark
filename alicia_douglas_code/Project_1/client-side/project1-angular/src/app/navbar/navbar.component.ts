import { CurrentUserService } from './../current-user.service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users.model';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  routerLink;
  user: Users;

  constructor(private currentUser: CurrentUserService) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
    this.setUpNavbar(this.user);
  }

  setUpNavbar(user) {
    const home = document.getElementsByClassName('home');
    if (user.pos_id === 1) {
      for (let i = 0; i < home.length; i++) {
        // home[i]. = '/home';
        this.routerLink = '/home';
      }
    }
  }

  logout() {
    this.currentUser.setCurrentUser(null);
  }

}
