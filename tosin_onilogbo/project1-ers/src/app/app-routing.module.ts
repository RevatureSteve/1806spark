import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { RequestComponent } from './request/request.component';
import { ViewRequestsComponent } from './view-requests/view-requests.component';
import { StatusRequestComponent } from './status-request/status-request.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ManagerDashboardComponent } from './manager-dashboard/manager-dashboard.component';
import { LoginComponent } from './login/login.component';
import { PendingPageComponent } from './pending-page/pending-page.component';
import { CompletedPageComponent } from './completed-page/completed-page.component';
import { ViewEmployeesComponent } from './view-employees/view-employees.component';
const routes: Routes = [
  {
  path: 'profile',
  component: ProfileComponent
}, {
  path: 'submit-request',
  component: RequestComponent
}, {
  path: 'view-requests',
  component: ViewRequestsComponent
}, {
  path: 'update-status',
  component: StatusRequestComponent 
}, {
  path: 'dashboard',
  component: DashboardComponent
}, {
  path: 'manager-dashboard',
  component: ManagerDashboardComponent
}, {
  path: '',
  component: LoginComponent
}, {
  path: 'pending-page',
  component: PendingPageComponent
}, {
  path: 'completed-page',
  component: CompletedPageComponent
}, {
  path: 'view-employees',
  component: ViewEmployeesComponent
}
];

@NgModule({
  imports: [
    CommonModule, RouterModule.forRoot(routes),
  ], 
  declarations: [], 
  exports: [ RouterModule ]
})

@NgModule({
 
})

export class AppRoutingModule { }
