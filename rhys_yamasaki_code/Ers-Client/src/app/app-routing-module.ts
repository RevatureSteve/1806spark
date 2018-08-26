import { ReimbursementsByIdComponent } from './pages/reimbursements-by-id/reimbursements-by-id.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { ManagerComponent } from './pages/manager/manager.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginComponent } from './pages/login/login.component';
import { ViewEmployeesComponent } from './pages/view-employees/view-employees.component';

export const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'manager/home', component: ManagerComponent},
  {path: 'employee/home', component: EmployeeComponent},
  {path: 'manager/view/employees', component: ViewEmployeesComponent},
  {path: 'manager/view/employee', component: ReimbursementsByIdComponent},
  {path: '**', redirectTo: 'login'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
