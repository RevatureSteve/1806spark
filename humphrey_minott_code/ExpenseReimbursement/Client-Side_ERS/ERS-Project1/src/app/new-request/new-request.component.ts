import { LoginServiceService } from './../login-service.service';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Reimbursement } from '../reimbursement';

@Component({
  selector: 'app-new-request',
  templateUrl: './new-request.component.html',
  styleUrls: ['./new-request.component.css']
})
export class NewRequestComponent implements OnInit {

  newRequest: Reimbursement;
  success: number;
  visible:boolean= true;

  constructor(private employeeService: EmployeeService, private loginService:LoginServiceService) { }

  ngOnInit() {
    this.newRequest={
      rId: 0,
      requestTypeId: 0,
      submissionUId: this.loginService.dbUser.uId,
      resolvedUId: 0,
      requestStatusId: 1,
      amount: 0,
      description: "",
      image: null,
      timeSubmission: "",
      fname: this.loginService.dbUser.fname,
      lname: this.loginService.dbUser.lname,
      rq_type: "",
      requestStatus: "pending",
      position_Id: 0,
      email:"",
      password:""
    }
    }

    sendRequest(){
      console.log("sending:" + this.newRequest);
      this.createNewRequest(this.newRequest);
      this.visible =false;
    }

    createNewRequest(request:Reimbursement){
      // request.rq_type=request.rq_type[0];
      if(request.rq_type == "Food"){
        request.requestTypeId=1;
      }
      else if(request.rq_type == "Other"){
        request.requestTypeId=4;
      }
      else if(request.rq_type == "Lodging"){
        request.requestTypeId=2;
      }
      else if(request.rq_type == "Transportation"){
        request.requestTypeId=3;
      }
      console.log(request);
      this.employeeService.createRequest(request).subscribe(r => {});
    }

}
