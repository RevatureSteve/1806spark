import { LoginComponent } from './pages/login/login.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing-module';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ManagerComponent } from './pages/manager/manager.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { ViewReimbursementsComponent } from './pages/view-reimbursements/view-reimbursements.component';
import { NavbarComponent } from './pages/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ManagerComponent,
    EmployeeComponent,
    ViewReimbursementsComponent,
    NavbarComponent,
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
