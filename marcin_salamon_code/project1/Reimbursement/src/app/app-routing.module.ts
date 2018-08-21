import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { EmployeeComponent } from './employee/employee.component';
import { SubmitComponent } from './submit/submit.component';
import { ReimbursementDetailsComponent } from './reimbursement-details/reimbursement-details.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'employee', component: EmployeeComponent},
  {path: 'employee/submit', component: SubmitComponent},
  { path: 'detail/:id', component: ReimbursementDetailsComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
