import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  loggedUser: User;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.userService.subscribers.subscribe(user => {
      this.loggedUser = user;
    });
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['login']);
    this.userService.subscribers.next(null);
  }
}
