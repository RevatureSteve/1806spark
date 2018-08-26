import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoggedUserService } from '../services/logged-user.service';

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
