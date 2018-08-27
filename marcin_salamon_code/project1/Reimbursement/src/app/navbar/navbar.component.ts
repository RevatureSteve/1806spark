import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoggedUserService } from '../services/logged-user.service';
import { DecisionsService } from '../services/decisions.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(private logged: LoggedUserService, private routes: Router, private decision: DecisionsService) { }

  ngOnInit() {

  }

  logout(): void {
    if (this.logged.getLoggedUser().positionId === 2) {
      this.decision.clear();
    }
    this.logged.logout();
    this.routes.navigate(['/']);
  }
}
