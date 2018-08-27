import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../users-service';

@Component({
  selector: 'app-manager-home',
  templateUrl: './manager-home.component.html',
  styleUrls: ['./manager-home.component.css']
})
export class ManagerHomeComponent implements OnInit {

  constructor(private service : UsersService) { }
  
   usr = this.service.currentLoggedUser();
   user = JSON.stringify(this.usr);
   uu = this.user.valueOf();
   final = JSON.parse(this.uu);
  ngOnInit() {
  
  }


  

}
