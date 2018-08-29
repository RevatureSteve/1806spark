import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
// import { NavbarComponent } from './navbar/navbar.component';
import { LoginBoxComponent } from './login-box/login-box.component';
import { ManagerNavbarComponent } from './manager-navbar/manager-navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { DashBoardBoxComponent } from './dash-board-box/dash-board-box.component';
import { EmployeePageComponent } from './employee-page/employee-page.component';
import { FormsModule } from '@angular/forms';
import { EmployeeNavComponent } from './employee-nav/employee-nav.component';
import { NewRequestComponent } from './new-request/new-request.component';
import { EmployeeViewRequestsComponent } from './employee-view-requests/employee-view-requests.component';
import { ProfileComponent } from './profile/profile.component';
import { ManagerViewRequestComponent } from './manager-view-request/manager-view-request.component';
import { ManagerViewEmployeesComponent } from './manager-view-employees/manager-view-employees.component';
import { RouterModule, ROUTES } from '@angular/router';
import { ManagerViewSpecificComponent } from './manager-view-specific/manager-view-specific.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    // NavbarComponent,
    LoginBoxComponent,
    ManagerNavbarComponent,
    LoginPageComponent,
    DashBoardBoxComponent,
    EmployeePageComponent,
    EmployeeNavComponent,
    NewRequestComponent,
    EmployeeViewRequestsComponent,
    ProfileComponent,
    ManagerViewRequestComponent,
    ManagerViewEmployeesComponent,
    ManagerViewSpecificComponent,
    CreateEmployeeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
