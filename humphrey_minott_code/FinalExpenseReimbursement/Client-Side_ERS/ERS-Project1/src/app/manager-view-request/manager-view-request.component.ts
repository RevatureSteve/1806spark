import { ManagerServiceService } from './../manager-service.service';
import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../reimbursement';
import { User } from '../user';
import { EmployeeService } from '../employee.service';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-manager-view-request',
  templateUrl: './manager-view-request.component.html',
  styleUrls: ['./manager-view-request.component.css']
})
export class ManagerViewRequestComponent implements OnInit {

  newRequest: Reimbursement;
  listOfRequests: Reimbursement[];
  listOfResolvedRequests: Reimbursement[];
  listOfDeniedRequests: Reimbursement[];
  listOfAllRequests: Reimbursement[];
  manager:User;
  currentEmployee: User;
  employeeWhoMadeRequest: User;
  managerWhoResolved: User;
  itsPending:boolean;
  itsDenied:boolean;
  itsAccepted:boolean;

  constructor(private employeeService: EmployeeService, private loginService:LoginServiceService,private managerService: ManagerServiceService) {

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
  all: boolean = false;

  clickPending(){
    this.pending = true;
    this.resolved = false;
    this.declined = false;
    this.all = false;
    this.getPendingListNow();
  }

  clickResolved(){
    this.pending = false;
    this.resolved = true;
    this.declined = false;
    this.all = false;
    this.getResolvedListNow();
  }

  clickDeclined(){
    this.pending = false;
    this.resolved = false;
    this.declined = true;
    this.all = false;
    this.getDeniedListNow();
  }

  clickAll(){
    this.pending = false;
    this.resolved = false;
    this.declined = false;
    this.all = true;
    this.getAllListNow();
  }

      getAllListNow(){
        this.getAllRequests();
      }

      getPendingListNow(){
        this.getRequestByStatusPending("pending");
      }

      getResolvedListNow(){
        this.getResolvedRequestByStatus("accepted");
      }
      getDeniedListNow(){
        this.getDeniedRequestByStatus("denied");
      }
  
      getEmployeeById(id:Number){
        console.log("getEmployeeCalled");
        this.loginService.getEmployeeById(id).subscribe(succ => {
          this.manager = succ
        });
      }

      getRequestByStatusPending(status:string){
        this.managerService.getAllRequestsByStatus(status).subscribe(succ => {
          this.listOfRequests = succ;
          console.log(this.listOfRequests);
        }, err => {
          console.log('login failed')
        }
        );
      }

      getResolvedRequestByStatus(status:string){
        this.managerService.getAllRequestsByStatus(status).subscribe(succ => {
          this.listOfResolvedRequests = succ;
          console.log(this.listOfResolvedRequests);
        }, err => {
          console.log('login failed')
        }
        );
      }

      getDeniedRequestByStatus(status:string){
        this.managerService.getAllRequestsByStatus(status).subscribe(succ => {
          this.listOfDeniedRequests = succ;
          console.log(this.listOfDeniedRequests);
        }, err => {
          console.log('login failed')
        }
        );
      }

      getAllRequests(){
        this.managerService.getAllRequests().subscribe(succ => {

          this.listOfAllRequests = succ;
          console.log(this.listOfAllRequests);
        }, err => {
          console.log('login failed')
        }
        );
      }

      updateRequestStatus(request:Reimbursement, statusId:number){
        request.requestStatusId = statusId;
        request.resolvedUId = this.currentEmployee.uId;
        console.log("Sending update: " + request);
        this.managerService.updateRequestStatus(request).subscribe(r => {});
      }

      checkIfTrue(request:Reimbursement):boolean{
        if (request.requestStatus == "Pending"){
          console.log(status +" true")
          return true;
        }
        else{
          console.log(status +" false")
          return false;
        }
    }

    getEmployeeByUserId(userId:number):boolean{
       this.loginService.getEmployeeById(userId).subscribe(succ => {
        this.employeeWhoMadeRequest = succ;
        console.log(this.employeeWhoMadeRequest);
      }, err => {
        console.log('login failed')
      }
      );
      return true;
    }

    pendingReq(request:Reimbursement){
      if(request.requestStatus == "Pending"){
        return true;
      }
      else{
        return false;
      }
    }
    // checkIfReim(request:Reimbursement){
    //  this.newRequest = request;
    //  this.loginService.getEmployeeById(request.resolvedUId).subscribe(succ => {
    //   this.managerWhoResolved = succ;})
    //  if(request.requestStatus == "Pending"){
    //    this.itsPending = true;
    //    this.itsDenied = false;
    //    this.itsAccepted= false;
    //  }
    //  else if(request.requestStatus == "Denied"){
    //    this.itsPending = false;
    //    this.itsDenied = true;
    //    this.itsAccepted= false;
    //  }
    //  else if(request.requestStatus == "Accepted"){
    //    this.itsPending = false;
    //    this.itsDenied = false;
    //    this.itsAccepted= true;
    //  }}
    


  
}