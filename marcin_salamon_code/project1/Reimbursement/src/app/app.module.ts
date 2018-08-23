import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './navbar/login/login.component';
import { EmployeeComponent } from './navbar/employee/employee.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UpdateUserComponent } from './navbar/update-user/update-user.component';
import { ReimbursementListComponent } from './navbar/reimbursement-list/reimbursement-list.component';
import { SubmitComponent } from './navbar/submit/submit.component';
import { ReimbursementDetailsComponent } from './navbar/reimbursement-details/reimbursement-details.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    NavbarComponent,
    UpdateUserComponent,
    ReimbursementListComponent,
    SubmitComponent,
    ReimbursementDetailsComponent
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
