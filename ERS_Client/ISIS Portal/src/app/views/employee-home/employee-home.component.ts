import { UsersService } from './../../users-service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/Users';


@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {
  links = [
    'Home',
    'Agent Profile',
    'Missions',
    'Agent Status'
  ];
  agents : Users[];
  // Harcoded agent for testing
  


   constructor(private httpClient: HttpClient, private service :UsersService) { }
  ngOnInit() {
    this.httpClient.get<Users[]>('http://localhost:8080/ERS/GetAllEmployeesServlet')
    .subscribe(data => {
      this.agents = data;
      console.log(this.agents);
    }

    )
  }

}
