import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../users-service';

@Component({
  selector: 'app-manager-home',
  templateUrl: './manager-home.component.html',
  styleUrls: ['./manager-home.component.css']
})
export class ManagerHomeComponent implements OnInit {

  constructor(private service : UsersService) { }

  ngOnInit() {
    console.log("Manager....")
    let usr = this.service.currentLoggedUser();
    let user = JSON.stringify(usr);
    let uu = user.valueOf();
    let final = JSON.parse(uu);
  }


  

}
