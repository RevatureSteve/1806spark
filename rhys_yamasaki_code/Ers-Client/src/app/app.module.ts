import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing-module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { ManagerComponent } from './manager/manager.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeNavbarComponent } from './employee-navbar/employee-navbar.component';
import { ManagerNavbarComponent } from './manager-navbar/manager-navbar.component';
import { ViewReimbursementsComponent } from './view-reimbursements/view-reimbursements.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ManagerComponent,
    EmployeeComponent,
    EmployeeNavbarComponent,
    ManagerNavbarComponent,
    ViewReimbursementsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
