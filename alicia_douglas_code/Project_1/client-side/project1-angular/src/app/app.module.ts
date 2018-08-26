import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './/app-routing.module';
import { ProfileComponent } from './profile/profile.component';
import { EmployeeReimbursementComponent } from './employee-reimbursement/employee-reimbursement.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ReimbursementsService } from './reimbursements.service';
import { MainComponent } from './main/main.component';
import { HomeNavbarComponent } from './home-navbar/home-navbar.component';
import { EmpPendingReimbursementsComponent } from './emp-pending-reimbursements/emp-pending-reimbursements.component';
import { EmpResolvedReimbursementsComponent } from './emp-resolved-reimbursements/emp-resolved-reimbursements.component';
import { NewReimbursementComponent } from './new-reimbursement/new-reimbursement.component';
import { MainManagerComponent } from './main-manager/main-manager.component';
import { HomeNavManagerComponent } from './home-nav-manager/home-nav-manager.component';
import { ManagerReimbursementsComponent } from './manager-reimbursements/manager-reimbursements.component';
import { ManagerPendingReimbursementsComponent } from './manager-pending-reimbursements/manager-pending-reimbursements.component';
import { ManagerResolvedReimbursmentsComponent } from './manager-resolved-reimbursments/manager-resolved-reimbursments.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { ManagerNavbarComponent } from './manager-navbar/manager-navbar.component';
import { SingleEmployeeViewComponent } from './single-employee-view/single-employee-view.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent,
    EmployeeReimbursementComponent,
    NavbarComponent,
    MainComponent,
    HomeNavbarComponent,
    EmpPendingReimbursementsComponent,
    EmpResolvedReimbursementsComponent,
    NewReimbursementComponent,
    MainManagerComponent,
    HomeNavManagerComponent,
    ManagerReimbursementsComponent,
    ManagerPendingReimbursementsComponent,
    ManagerResolvedReimbursmentsComponent,
    EmployeeListComponent,
    ManagerNavbarComponent,
    SingleEmployeeViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [ReimbursementsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
