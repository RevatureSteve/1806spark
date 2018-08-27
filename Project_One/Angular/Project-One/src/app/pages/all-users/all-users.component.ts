import { Users } from './../../models/Users';
import { DataService } from './../../data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {
  allUsers: Users[];

  constructor(private data: DataService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers() {
    this.data.getUsers().subscribe(
      data => this.allUsers = data);
  }
}
