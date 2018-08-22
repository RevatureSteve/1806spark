import { Component, OnInit } from '@angular/core';
import { LoggedUserService } from '../logged-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private logged: LoggedUserService, private routes: Router) { }

  ngOnInit() {
  }

  logout(): void {
    this.logged.logout();
    this.routes.navigate(['/']);
  }
}
