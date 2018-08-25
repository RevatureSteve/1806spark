import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { SubmitComponent } from './pages/submit/submit.component';
import { ReimbursementDetailsComponent } from './pages/reimbursement-details/reimbursement-details.component';
import { UpdateUserComponent } from './pages/update-user/update-user.component';
import { ManagerComponent } from './pages/manager/manager.component';
import { UsersComponent } from './pages/manager/users/users.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'employee', component: EmployeeComponent},
  { path: 'employee/submit', component: SubmitComponent},
  { path: 'employee/detail/:id', component: ReimbursementDetailsComponent },
  { path: 'employee/account', component: UpdateUserComponent },
  { path: 'manager', component: ManagerComponent },
  { path: 'manager/submit', component: SubmitComponent },
  { path: 'manager/users/:id', component: ManagerComponent },
  { path: 'manager/detail/:id', component: ReimbursementDetailsComponent },
  { path: 'manager/account', component: UpdateUserComponent },
  { path: 'manager/employees', component: UsersComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
