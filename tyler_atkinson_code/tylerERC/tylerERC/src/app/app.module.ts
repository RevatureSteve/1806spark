import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule } from '@angular/forms'; 

import { AppRoutingModule } from './app-routing.module';
import { MainComponent } from './main/main.component';
import { ManagerComponent } from './manager/manager.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginComponent } from './login/login.component';
import { ViewrequestsComponent } from './viewrequests/viewrequests.component';
import { NewrequestComponent } from './newrequest/newrequest.component';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule }    from '@angular/common/http';
import { OneReimbursementComponent } from './one-reimbursement/one-reimbursement.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MainComponent,
    ManagerComponent,
    EmployeeComponent,
    LoginComponent,
    ViewrequestsComponent,
    NewrequestComponent,
    ProfileComponent,
    OneReimbursementComponent,
   
    

  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
