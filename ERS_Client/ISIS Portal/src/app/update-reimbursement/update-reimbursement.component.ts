import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users-service';

@Component({
  selector: 'app-update-reimbursement',
  templateUrl: './update-reimbursement.component.html',
  styleUrls: ['./update-reimbursement.component.css']
})
export class UpdateReimbursementComponent implements OnInit {
  rId: number;
  status: number;
  rs : any;
  usr = this.service.currentLoggedUser();
  user = JSON.stringify(this.usr);
  uu = this.user.valueOf();
  final = JSON.parse(this.uu);
  constructor(private service : UsersService, private httpClient : HttpClient) { }

  ngOnInit() {
  }

start() {
  console.log(this.rId);
  console.log(this.status);
  if (this.rId != null && this.status == 1 || this.status == 2)
  this.updateReimbursement(this.rId, this.status);
}

updateReimbursement(rId: number, status: number) {
  this.httpClient.post('http://localhost:8080/ERS/UpdateReimbursementServlet?rId=' + this.rId + '&rStatusId=' + this.status, this.rs )
.subscribe(data => {
  this.rs =data;
  let f = JSON.parse(this.rs);
  console.log(f);
  if (f != null) {
    if (f == 2 )
    alert("Successfully approved a request.");
  }
  else {
    alert("Successfuly denied a request.");
  }
})

}

}
