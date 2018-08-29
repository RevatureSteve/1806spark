import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AppRoutingModule } from './/app-routing.module';
import { ManagerComponent } from './pages/manager/manager.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { LoginComponent } from './pages/login/login.component';
import { EmpComponent } from './models/emp/emp.component';
import { MgrComponent } from './models/mgr/mgr.component';

import { ProfileComponent } from './profile/profile.component';
import { EmployeeReimbursementComponent } from './employee-reimbursement/employee-reimbursement.component';
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
import { NewEmployeeComponent } from './new-employee/new-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ManagerComponent,
    EmployeeComponent,
    LoginComponent,
    EmpComponent,
    MgrComponent,
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
    SingleEmployeeViewComponent,
    NewEmployeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ReimbursementsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
