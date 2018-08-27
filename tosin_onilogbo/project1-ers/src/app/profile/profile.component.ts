import { Component, OnInit } from '@angular/core';
import {DataServiceService} from '../data-service.service';
import { ObjectUnsubscribedError, Observable } from 'rxjs';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  fname: string;
  lname: string;
  password: string;
  constructor(private data: DataServiceService) { }

  ngOnInit() {
  }

  updateUser() {

    this.data.updateUser(this.fname, this.lname, this.password);


  }

}
