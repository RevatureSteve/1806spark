import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../login-service.service';
import { User } from '../user';

@Component({
  selector: 'app-dash-board-box',
  templateUrl: './dash-board-box.component.html',
  styleUrls: ['./dash-board-box.component.css']
})
export class DashBoardBoxComponent implements OnInit {


dbUser: User;
  constructor(private loginService: LoginServiceService) { 
    this.dbUser = this.loginService.getUser();
  }

  ngOnInit() {
    this.dbUser = this.loginService.getUser();
  }

}
