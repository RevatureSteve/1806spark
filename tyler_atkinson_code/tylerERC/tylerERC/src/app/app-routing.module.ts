import { MainComponent } from './main/main.component';
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ManagerComponent } from './manager/manager.component';
import { EmployeeComponent } from './employee/employee.component';


export const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: MainComponent},
  {path: 'Manager', component: ManagerComponent},
  {path: 'Employee', component: EmployeeComponent},


]




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
