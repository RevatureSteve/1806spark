import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementListService } from '../services/reimbursement-list.service';
import { Reimbursement } from '../models/reimbursement';
import { Location } from '@angular/common';
import { OReimbursementService } from '../oreimbursement.service';
import { User } from '../models/user';
import { UserListService } from '../userlistservice.service';

@Component({
  selector: 'app-viewusers',
  templateUrl: './viewusers.component.html',
  styleUrls: ['./viewusers.component.css']
})
export class ViewusersComponent implements OnInit {

  clickMessage = '';
  
  users: User[];
  userlistservice: any;
  
  constructor(private userlistService: UserListService ){}
  
  ngOnInit() {
    this.getUsers();
    console.log(this.users);
  }

  getUsers() {
  this.userlistService.getUsers()
  .subscribe(users => this.users = users);
  console.log(this.users);
}


}





