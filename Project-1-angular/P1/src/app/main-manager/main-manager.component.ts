import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../current-user.service';
import { Router } from '@angular/router';
import { Users } from '../models/users.model';

@Component({
  selector: 'app-main-manager',
  templateUrl: './main-manager.component.html',
  styleUrls: ['./main-manager.component.css']
})
export class MainManagerComponent implements OnInit {

  user: Users;

  constructor(private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
  }

  checkUser() {
    if (!this.user || this.user.pos_id !== 2) {
      this.router.navigate(['/login']);
    }
  }

}
