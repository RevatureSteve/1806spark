import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './navbar/login/login.component';
import { EmployeeComponent } from './navbar/employee/employee.component';
import { ReimbursementDetailsComponent } from './navbar/reimbursement-details/reimbursement-details.component';
import { SubmitComponent } from './navbar/submit/submit.component';
import { UpdateUserComponent } from './navbar/update-user/update-user.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'employee', component: EmployeeComponent},
  { path: 'employee/submit', component: SubmitComponent},
  { path: 'employee/detail/:id', component: ReimbursementDetailsComponent },
  { path: 'employee/account', component: UpdateUserComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
