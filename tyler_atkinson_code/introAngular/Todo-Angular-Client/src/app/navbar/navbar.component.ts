import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  username = 'bobbert';
  count = 0;

  constructor() { }

  updateUsername = function () {
    console.log('username' +  this.username);
    

  }

  updateCount = function (){

    this.count++

  }

  ngOnInit() {
  }

}
