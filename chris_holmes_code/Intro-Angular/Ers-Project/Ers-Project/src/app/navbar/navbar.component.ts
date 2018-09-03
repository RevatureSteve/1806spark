import { Component, OnInit } from '@angular/core';
import { LoggeduserService } from '../services/loggeduser.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loggedUserService: LoggeduserService) { }

  ngOnInit() {
  }

}
