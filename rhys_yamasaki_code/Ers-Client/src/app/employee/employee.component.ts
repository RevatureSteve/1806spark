import { ActivatedRoute } from '@angular/router';
import { LoggedInService } from './../logged-in.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  user: User;

  constructor(private httpClient: HttpClient, private logged: LoggedInService, private route: ActivatedRoute) {
    // this.route.data.subscribe(params => this.user = params.pos_name);
   }

  ngOnInit() {
    this.user = this.logged.getLoggedInUser();
  }

}
