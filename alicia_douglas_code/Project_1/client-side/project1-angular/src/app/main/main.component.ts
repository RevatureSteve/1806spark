import { CurrentUserService } from './../current-user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  navbar;

  constructor(private currentUser: CurrentUserService) { }

  ngOnInit() {
    // this.validatePostition(this.currentUser.getCurrentUser().pos_id);
    // this.validatePostition(1);
  }

  // validatePostition(posId) {
  //   console.log('validate position fn');
  //   this.navbar = document.getElementById('home-nav-bar');
  //   if (posId === 1) {
  //     this.navbar.appendChild('home-nav-bar');
  //     // document.getElementById('home-nav-bar').innerHTML = '<app-home-navbar></app-home-navbar>';
  //     // this.navbar = '<app-home-navbar></app-home-navbar>';
  //   }
  // }

}
