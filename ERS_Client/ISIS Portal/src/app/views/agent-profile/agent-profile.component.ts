import { Component, OnInit } from '@angular/core';
import { UsersService } from './../../users-service';


@Component({
  selector: 'app-agent-profile',
  templateUrl: './agent-profile.component.html',
  styleUrls: ['./agent-profile.component.css']
})
export class AgentProfileComponent implements OnInit {

  constructor(private service: UsersService ) { }

  usr = this.service.currentLoggedUser();
 user = JSON.stringify(this.usr);
 uu = this.user.valueOf();
 final = JSON.parse(this.uu);

  ngOnInit() {
  
  }

}
