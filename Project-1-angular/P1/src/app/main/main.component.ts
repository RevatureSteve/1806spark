import { CurrentUserService } from './../current-user.service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  user: Users;

  constructor(private currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
    this.user = this.currentUser.getCurrentUser();
  }

  checkUser() {
    if (!this.user || this.user.pos_id !== 1) {
      this.router.navigate(['/login']);
    }
  }

}
