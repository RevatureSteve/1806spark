import { HttpClient } from '@angular/common/http';
import { UsersService } from './../users-service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-reimbursemet',
  templateUrl: './new-reimbursemet.component.html',
  styleUrls: ['./new-reimbursemet.component.css']
})
export class NewReimbursemetComponent implements OnInit {
amount : number;
rDescription: string;
rType: number;
uId: number;
rb: any;

  constructor(private service : UsersService, private httpClient: HttpClient,
  private router: Router ) { }
     usr = this.service.currentLoggedUser();
     user = JSON.stringify(this.usr);
     uu = this.user.valueOf();
     final = JSON.parse(this.uu);
  ngOnInit() {
  }

 start (){
    console.log(this.amount);
    console.log(this.rDescription);
    console.log(this.rType);
    this.createReimmbursement(this.amount, this.rDescription, this.final.empId, this.rType);
 }
    createReimmbursement(amount: number, rDesription: string, uId, rType: number) {
      if (this.rType > 4 || this.rType < 0) {
        alert("Request type must be 1, 2, 3, or 4. Try agin.")
      }
      else if (this.amount < 0  || uId == null) {
        alert("Please try agaon with a non negative number.")
      }
    this.httpClient.post('http://localhost:8080/ERS/NewReimbursementServlet?amount=' + this.amount + '&rDescription=' + this.rDescription + '&empId=' + uId+ '&rTypeId=' + this.rType , this.rb)
  .subscribe(data => {
    this.rb = data;
    console.log("This" + this.rb);
   
    let c = JSON.parse(this.rb);
    console.log(c);

    if (c != null ) {
      alert("Your request has been submitted successfully. ");
      this.router.navigate(['agnet/reimbursements']);
    }
  
  })
  }

}
