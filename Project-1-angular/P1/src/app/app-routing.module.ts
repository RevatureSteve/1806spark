import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './pages/login/login.component';
import { SingleEmployeeViewComponent } from './single-employee-view/single-employee-view.component';
import { MainManagerComponent } from './main-manager/main-manager.component';
import { MainComponent } from './main/main.component';
import { ProfileComponent } from './profile/profile.component';
import { NewReimbursementComponent } from './new-reimbursement/new-reimbursement.component';
import { NewEmployeeComponent } from './new-employee/new-employee.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'home', component: MainComponent},
  {path: 'home/manager', component: MainManagerComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'new-reimbursement', component: NewReimbursementComponent},
  {path: 'employee/:id', component: SingleEmployeeViewComponent},
  {path: 'new-employee', component: NewEmployeeComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
