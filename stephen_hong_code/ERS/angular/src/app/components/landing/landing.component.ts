import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  user: User;

  constructor(private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('user') == null) {
      this.router.navigate(['login']);
    } else {
      this.user = JSON.parse(localStorage.getItem('user'));
    }
  }
}