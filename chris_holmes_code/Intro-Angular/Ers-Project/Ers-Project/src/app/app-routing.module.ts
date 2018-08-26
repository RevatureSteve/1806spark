import { EmployeeHomepageComponent } from './employee-homepage/employee-homepage.component';
import { ManagerReimbursementsComponent } from './manager-reimbursements/manager-reimbursements.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'reimbursements', component: ManagerReimbursementsComponent},
  {path: 'employee-homepage', component: EmployeeHomepageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
