import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './pages/login/login.component';
import { EmployeeHomeComponent } from './pages/employee-home/employee-home.component';
import { ManagerHomeComponent } from './pages/manager-home/manager-home.component';
import { ViewReimbursementsComponent } from './pages/view-reimbursements/view-reimbursements.component';
import { SubmitReimbursementsComponent } from './pages/submit-reimbursements/submit-reimbursements.component';
import { ViewUserResolvedComponent } from './pages/view-user-resolved/view-user-resolved.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    EmployeeHomeComponent,
    ManagerHomeComponent,
    ViewReimbursementsComponent,
    SubmitReimbursementsComponent,
    ViewUserResolvedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
