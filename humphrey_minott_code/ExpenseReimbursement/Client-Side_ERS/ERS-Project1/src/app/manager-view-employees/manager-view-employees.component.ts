import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../reimbursement';
import { User } from '../user';
import { EmployeeService } from '../employee.service';
import { LoginServiceService } from '../login-service.service';
import { ManagerServiceService } from '../manager-service.service';

@Component({
  selector: 'app-manager-view-employees',
  templateUrl: './manager-view-employees.component.html',
  styleUrls: ['./manager-view-employees.component.css']
})
export class ManagerViewEmployeesComponent implements OnInit {
  newRequest: Reimbursement;
  listOfRequests: Reimbursement[];
  listOfResolvedRequests: Reimbursement[];
  listOfDeniedRequests: Reimbursement[];
  listOfAllRequests: Reimbursement[];
  manager:User;
  currentEmployee: User;
  employeeWhoMadeRequest: User;
  allEmployee:User[];
  managerSpecific:boolean = false;
  viewAll:boolean = true;
  wantToSeeEmployee: User;

  constructor(private employeeService: EmployeeService, private loginService:LoginServiceService,private managerService: ManagerServiceService) {

    this.currentEmployee= this.loginService.dbUser;

    
   }

  ngOnInit() {
    this.managerService.getAllEmployees().subscribe(succ => {
      this.allEmployee = succ;
    });

    this.wantToSeeEmployee = {
      uId: 0,
      email: "",
      password: "",
      fname: "",
      lname: "",
      positionId: 0,
      employeeReimbursements: null
    };

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
        console.log(request);
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
    checkEmployee(){
      this.getAllEmployees();
    }
    getAllEmployees(){
      console.log("getEmployeeCalled");
      this.managerService.getAllEmployees().subscribe(succ => {
        this.allEmployee = succ;
      });
    }

    managerSeeEmp(employee){
      this.managerService.saveCurrent(employee);
      this.managerSpecific=true;
      this.viewAll=false;
    }


  }
  
