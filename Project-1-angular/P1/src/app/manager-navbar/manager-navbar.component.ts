import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../current-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager-navbar',
  templateUrl: './manager-navbar.component.html',
  styleUrls: ['./manager-navbar.component.css']
})
export class ManagerNavbarComponent implements OnInit {

  constructor(private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
  }

  logout() {
    this.currentUser.setCurrentUser(null);
    this.router.navigate(['login']);
  }

}
