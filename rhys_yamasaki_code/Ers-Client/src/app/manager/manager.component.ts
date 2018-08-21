import { LoggedInService } from './../logged-in.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {User} from '../user';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  user: User;

  constructor(private logged: LoggedInService, private route: ActivatedRoute) {
    // this.route.component: 'ManagerComponent';
    // this.route.params.subscribe(params => this.user = params.pos_name);
   }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
  }

}
