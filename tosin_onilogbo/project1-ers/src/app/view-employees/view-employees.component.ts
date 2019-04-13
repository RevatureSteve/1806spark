import { Component, OnInit } from '@angular/core';
import { User } from '../userclass';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-view-employees',
  templateUrl: './view-employees.component.html',
  styleUrls: ['./view-employees.component.css']
})
export class ViewEmployeesComponent implements OnInit {
  users: User[];
  user: User;
  empId;
  constructor(private data: DataServiceService) { }

  ngOnInit() {
    this.getAllUsers();
    this.user = this.data.user;
    this.empId = this.user.userID;
  }

  getAllUsers (){
    this.data.readUsers().subscribe(userss => {
      this.users = userss
    });
  }
}
