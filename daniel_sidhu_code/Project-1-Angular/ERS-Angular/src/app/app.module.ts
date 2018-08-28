/*
  When I generate a component, double check this page!!
  This page is resposible for all the routing to different pages (i.e. home, login, ect.)
  each component should have an import and an export
*/

import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { EmployeeComponent } from './employee/employee.component';
import { ManagerComponent } from './manager/manager.component';
import { HttpClientModule } from '@angular/common/http';
import { ManagerProfileComponent } from './manager-profile/manager-profile.component';
import { EmployeeProfileComponent } from './employee-profile/employee-profile.component';
import { ManagerViewEmployeesComponent } from './manager-view-employees/manager-view-employees.component';
import { ManagerAllReimbursementsComponent } from './manager-all-reimbursements/manager-all-reimbursements.component';
import { ManagerPendingReimbursementsComponent } from './manager-pending-reimbursements/manager-pending-reimbursements.component';
import { ManagerApprovedReimbursementsComponent } from './manager-approved-reimbursements/manager-approved-reimbursements.component';
import { EmployeePendingReimbursementsComponent } from './employee-pending-reimbursements/employee-pending-reimbursements.component';
import { NewReimbursementComponent } from './new-reimbursement/new-reimbursement.component';
import { EmployeeApprovedReimbursementsComponent } from './employee-approved-reimbursements/employee-approved-reimbursements.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    EmployeeComponent,
    ManagerComponent,
    ManagerProfileComponent,
    EmployeeProfileComponent,
    ManagerViewEmployeesComponent,
    ManagerAllReimbursementsComponent,
    ManagerPendingReimbursementsComponent,
    ManagerApprovedReimbursementsComponent,
    EmployeePendingReimbursementsComponent,
    NewReimbursementComponent,
    EmployeeApprovedReimbursementsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
