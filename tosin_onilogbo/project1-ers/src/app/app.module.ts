import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

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
    ManagerNavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
