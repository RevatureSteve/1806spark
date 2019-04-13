import { Component, OnInit } from '@angular/core';
import {DataServiceService} from '../data-service.service';
import { ObjectUnsubscribedError, Observable } from 'rxjs';
import { User } from '../userclass';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  constructor(private data: DataServiceService, private http: HttpClient) { }

  editUser = false;

  ngOnInit() {
  }

  updateUser() {
    this.editUser = true;
  }

  save() {
    //post and change edit user to false
    this.data.updateUser(this.data.user).subscribe();
    this.editUser = false;
  }

}
