import { DataService } from './../data.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users$: Object;

  constructor(private data: DataService) { }

  // anything in here will be executed when this component loads
  ngOnInit() {
  this.data.getUsers().subscribe(
    data => this.users$ = data
  );
  }

}
