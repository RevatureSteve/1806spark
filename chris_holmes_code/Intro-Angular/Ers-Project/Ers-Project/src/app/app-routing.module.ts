import { ManagerHomepageComponent } from './manager-homepage/manager-homepage.component';
import { EmployeeHomepageComponent } from './employee-homepage/employee-homepage.component';
import { ManagerReimbursementsComponent } from './manager-reimbursements/manager-reimbursements.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateReimbursementComponent } from './create-reimbursement/create-reimbursement.component';
import { LogouthpComponent } from './logouthp/logouthp.component';


export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'reimbursements', component: CreateReimbursementComponent},
  {path: 'employee-homepage', component: EmployeeHomepageComponent},
  {path: 'manager-homepage', component: ManagerHomepageComponent},
  {path: '', component: LogouthpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
