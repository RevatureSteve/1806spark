import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Reimbursement } from './../../models/reimbursement';



@Component({
  selector: 'app-all-reimbursements',
  templateUrl: './all-reimbursements.component.html',
  styleUrls: ['./all-reimbursements.component.css']
})
export class AllReimbursementsComponent implements OnInit {
  rb: Reimbursement[];

  
  constructor( private httpClient: HttpClient) { }

  ngOnInit() : void  {
    this.httpClient.get<Reimbursement[]>('http://localhost:8080/ERS/AllReimbursementsServlet')
    .subscribe(data => {
      this.rb = data;
        console.log(this.rb);
   })
        
  }
 


  

}
