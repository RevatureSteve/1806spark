import { LoggeduserService } from './../services/loggeduser.service';
import { User } from './../models/users';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';



 @Component({
  selector: 'app-manager-reimbursements',
  templateUrl: './manager-reimbursements.component.html',
  styleUrls: ['./manager-reimbursements.component.css']
})
export class ManagerReimbursementsComponent implements OnInit {


  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    }

}
