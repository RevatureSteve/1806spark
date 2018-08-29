import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { EmployeeService } from '../employee.service';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  visible:boolean=true;
  currentEmployee:User;
  showPasswordChanger:boolean = false;

  public validateUser1:User={
      uId: 2348,
      email: "sherronpowell5@yahoo.com",
      password: "junior",
      fname: "Sherron",
      lname: "Powell",
      positionId: 1,
      employeeReimbursements: null
  };

  fname: string = this.getFirstname();
  
  constructor(private employeeService: EmployeeService,private loginService:LoginServiceService) { 
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
