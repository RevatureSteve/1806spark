import { EasterEggComponent } from './pages/easter-egg/easter-egg.component';
import { ReimbursementsByIdComponent } from './pages/reimbursements-by-id/reimbursements-by-id.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { ManagerComponent } from './pages/manager/manager.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginComponent } from './pages/login/login.component';
import { ViewEmployeesComponent } from './pages/view-employees/view-employees.component';
import { EmployeeProfileComponent } from './pages/employee-profile/employee-profile.component';

export const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'manager/home', component: ManagerComponent},
  {path: 'employee/home', component: EmployeeComponent},
  {path: 'manager/view/employees', component: ViewEmployeesComponent},
  {path: 'manager/view/employees/:id', component: ReimbursementsByIdComponent},
  {path: 'employee/profile', component: EmployeeProfileComponent},
  {path: 'easteregg', component: EasterEggComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
