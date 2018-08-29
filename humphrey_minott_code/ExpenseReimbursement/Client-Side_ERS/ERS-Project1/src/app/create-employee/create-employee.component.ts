import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { EmployeeService } from '../employee.service';
import { LoginServiceService } from '../login-service.service';
import { ManagerServiceService } from '../manager-service.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  visible:boolean=true;
  currentEmployee:User;
  showPasswordChanger:boolean = false;

  public validateUser1:User={
      uId: 0,
      email: "",
      password: "",
      fname: "",
      lname: "",
      positionId: 1,
      employeeReimbursements: null
  };

  fname: string = this.getFirstname();
  
  constructor(private employeeService: EmployeeService,private loginService:LoginServiceService,private managerService:ManagerServiceService) { 
    if(this.visible==false){
      this.visible=true;
    }
    this.showPasswordChanger = false;
  }
  
getFirstname(){
  return this.validateUser1.fname;
}

close(){
  this.visible =false;
  this.createEmployeeNow(this.validateUser1);
}
  ngOnInit() {

    if(this.visible==false){
      this.visible=true;
    }
    this.currentEmployee = this.loginService.getUser();
    this.showPasswordChanger = false;
}

sendNewName(){
  this.updateName(this.currentEmployee);
}

updateName(employee:User){

  console.log(employee);
  this.employeeService.updateName(employee).subscribe(r => {});
}

setPosition(statusId:number){
  this.validateUser1.positionId = statusId;
}


checkValidPassword(){
  let inputBox = (<HTMLInputElement>document.getElementById("currentPass"));
  let inputPassword:string = (<HTMLInputElement>document.getElementById("currentPass")).value;
  if(inputPassword == this.currentEmployee.password){
    this.showPasswordChanger = true;
    inputBox.style.border = "1px solid grey";
  }
  else if(inputPassword != this.currentEmployee.password){
    this.showPasswordChanger = false;
    inputBox.style.border = "thick solid #E82C0C";
  }


}

createEmployeeNow(employee:User){
  this.managerService.createEmployee(employee).subscribe(r => {});
}

checkConfirmerAndUpdate(){
  let inputBox1 = (<HTMLInputElement>document.getElementById("confirmMatch"));
  let inputBox2 = (<HTMLInputElement>document.getElementById("startMatch"));
  let inputPassword1:string = (<HTMLInputElement>document.getElementById("startMatch")).value;
  let inputPassword2:string = (<HTMLInputElement>document.getElementById("confirmMatch")).value;
  if(inputPassword1 == inputPassword2){
    inputBox1.style.border = "thick solid #00FF4B";
    inputBox2.style.border = "thick solid #00FF4B";
    this.currentEmployee.password = inputPassword2;
    console.log("Sending" + this.currentEmployee);
    this.employeeService.updatePassword(this.currentEmployee).subscribe(r => {});
  }
  else if(inputPassword1 != inputPassword2){
    inputBox1.style.border = "thick solid #E82C0C";
    inputBox2.style.border = "thick solid #E82C0C";
  }

}

}