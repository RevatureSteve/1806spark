import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../reimbursement';
import { EmployeeService } from '../employee.service';
import { LoginServiceService } from '../login-service.service';
import { User } from '../user';

@Component({
  selector: 'app-employee-view-requests',
  templateUrl: './employee-view-requests.component.html',
  styleUrls: ['./employee-view-requests.component.css']
})
export class EmployeeViewRequestsComponent implements OnInit {

  newRequest: Reimbursement;
  listOfRequests: Reimbursement[];
  listOfResolvedRequests: Reimbursement[];
  listOfDeniedRequests: Reimbursement[];
  manager:User;
  currentEmployee: User;

  constructor(private employeeService: EmployeeService, private loginService:LoginServiceService) {

    this.currentEmployee= this.loginService.dbUser

     this.newRequest={
      rId: 0,
      requestTypeId: 0,
      submissionUId: 2,//this.loginService.dbUser.uId,
      resolvedUId: 0,
      requestStatusId: 1,
      amount: 500,
      description: "ihljbsliselis blach seiht lbis asokfseui etsef slfseg se",
      image: null,
      timeSubmission: "wednseday",
      fname: "junior",//this.loginService.dbUser.fname,
      lname: "minott", //this.loginService.dbUser.lname,
      rq_type: "Food",
      requestStatus: "pending",
      password:"",
      email:"",
      position_Id: 1,
    }
   }

  ngOnInit() {
   }

    pending: boolean = false;
  resolved: boolean = false;
  declined: boolean = false;

  clickPending(){
    this.pending = true;
    this.resolved = false;
    this.declined = false;
    this.getPendingListNow();
  }

  clickResolved(){
    this.pending = false;
    this.resolved = true;
    this.declined = false;
    this.getResolvedListNow();
  }

  clickDeclined(){
    this.pending = false;
    this.resolved = false;
    this.declined = true;
    this.getDeniedListNow();
  }


      getPendingListNow(){
        this.getRequestByStatusId(this.currentEmployee.uId,"pending");
      }

      getResolvedListNow(){
        this.getResolvedRequestByStatusId(this.currentEmployee.uId,"accepted");
      }
      getDeniedListNow(){
        this.getDeniedRequestByStatusId(this.currentEmployee.uId,"denied");
      }
  
      getEmployeeById(id:Number){
        console.log("getEmployeeCalled");
        this.loginService.getEmployeeById(id).subscribe(succ => {
          this.manager = succ
        });
      }

      getRequestByStatusId(id:number,status:string){
        this.employeeService.getAllRequestByStatusId(id,status).subscribe(succ => {
          this.listOfRequests = succ;
          console.log(this.listOfRequests);
        }, err => {
          console.log('login failed')
        }
        );
      }

      getResolvedRequestByStatusId(id:number,status:string){
        this.employeeService.getAllRequestByStatusId(id,status).subscribe(succ => {
          this.listOfResolvedRequests = succ;
          console.log(this.listOfResolvedRequests);
        }, err => {
          console.log('login failed')
        }
        );
      }

      getDeniedRequestByStatusId(id:number,status:string){
        this.employeeService.getAllRequestByStatusId(id,status).subscribe(succ => {
          this.listOfDeniedRequests = succ;
          console.log(this.listOfDeniedRequests);
        }, err => {
          console.log('login failed')
        }
        );
      }


  }
  

