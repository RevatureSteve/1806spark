import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { EmployeehomeComponent } from './employeehome/employeehome.component';
import { HttpClientModule } from '@angular/common/http';
import { ManagerhomeComponent } from './managerhome/managerhome.component';
import { NewrequestComponent } from './newrequest/newrequest.component';
import { EmployeependingComponent } from './employeepending/employeepending.component';
import { EmployeeresolvedComponent } from './employeeresolved/employeeresolved.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { ManagerpendingComponent } from './managerpending/managerpending.component';
import { ManagerrequestsbyidComponent } from './managerrequestsbyid/managerrequestsbyid.component';
import { ManagerresolvedComponent } from './managerresolved/managerresolved.component';
import { ManagerviewemployeesComponent } from './managerviewemployees/managerviewemployees.component';
import { ManagernavbarComponent } from './managernavbar/managernavbar.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DashboardComponent,
    LoginComponent,
    LogoutComponent,
    EmployeehomeComponent,
    ManagerhomeComponent,
    NewrequestComponent,
    EmployeependingComponent,
    EmployeeresolvedComponent,
    EditprofileComponent,
    ManagerpendingComponent,
    ManagerrequestsbyidComponent,
    ManagerresolvedComponent,
    ManagerviewemployeesComponent,
    ManagernavbarComponent
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
