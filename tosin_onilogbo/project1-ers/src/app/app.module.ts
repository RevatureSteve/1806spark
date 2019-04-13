import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RequestComponent } from './request/request.component';
import { ManagerDashboardComponent } from './manager-dashboard/manager-dashboard.component';
import { ViewRequestsComponent } from './view-requests/view-requests.component';
import { StatusRequestComponent } from './status-request/status-request.component';
import { AppRoutingModule } from './/app-routing.module';
import { ManagerNavbarComponent } from './manager-navbar/manager-navbar.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ObjectUnsubscribedError, Observable } from 'rxjs';
import { PendingPageComponent } from './pending-page/pending-page.component';
import { CompletedPageComponent } from './completed-page/completed-page.component';
import { ViewEmployeesComponent } from './view-employees/view-employees.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DashboardComponent,
    LoginComponent,
    ProfileComponent,
    RequestComponent,
    ManagerDashboardComponent,
    ViewRequestsComponent,
    StatusRequestComponent,
    ManagerNavbarComponent,
    PendingPageComponent,
    CompletedPageComponent,
    ViewEmployeesComponent
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
