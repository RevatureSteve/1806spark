import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './pages/login/login.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UpdateUserComponent } from './pages/update-user/update-user.component';
import { ReimbursementListComponent } from './pages/reimbursement-list/reimbursement-list.component';
import { SubmitComponent } from './pages/submit/submit.component';
import { ReimbursementDetailsComponent } from './pages/reimbursement-details/reimbursement-details.component';
import { ManagerListComponent } from './pages/manager-list/manager-list.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    NavbarComponent,
    UpdateUserComponent,
    ReimbursementListComponent,
    SubmitComponent,
    ReimbursementDetailsComponent,
    ManagerListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
