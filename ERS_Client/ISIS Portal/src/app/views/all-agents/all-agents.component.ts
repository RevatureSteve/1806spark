import { HttpClient } from '@angular/common/http';
import { UsersService } from './../../users-service';
import { Component, OnInit } from '@angular/core';
import { Users } from '../../Users';

@Component({
  selector: 'app-all-agents',
  templateUrl: './all-agents.component.html',
  styleUrls: ['./all-agents.component.css']
})
export class AllAgentsComponent implements OnInit {
 
  agents: Users[];

  constructor( private httpClient: HttpClient) { }

  ngOnInit(): void {
  
      this.httpClient.get<Users[]>('http://localhost:8080/ERS/GetAllEmployeesServlet')
      .subscribe(data => {
        this.agents = data;
        console.log(this.agents);
      }

      )
      }
    
 
  }






  







