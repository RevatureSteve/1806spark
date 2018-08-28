import { Trainer } from './../../../models/trainer';
import { User } from './../../../models/user';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-profile-card',
  templateUrl: './profile-card.component.html',
  styleUrls: ['./profile-card.component.css']
})
export class ProfileCardComponent implements OnInit {

  @Input()
  user: User;
  @Input()
  trainer: Trainer;

  constructor() { }

  ngOnInit() {
  }

}
