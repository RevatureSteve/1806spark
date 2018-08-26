import { Component, OnInit } from '@angular/core';
import { LoggedUserService } from '../../services/logged-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  constructor(private logged: LoggedUserService, private routes: Router) { }

  ngOnInit() {
    if (!this.logged.getLoggedUser()) {
      this.routes.navigate(['/']);
    }
  }

}
