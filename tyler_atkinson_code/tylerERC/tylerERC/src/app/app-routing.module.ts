import { MainComponent } from './main/main.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ManagerComponent } from './manager/manager.component';
import { EmployeeComponent } from './employee/employee.component';
import { ViewrequestsComponent } from './viewrequests/viewrequests.component';
import { NewrequestComponent } from './newrequest/newrequest.component';
import { ProfileComponent } from './profile/profile.component';


export const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: MainComponent},
  {path: 'Manager', component: ManagerComponent},
  {path: 'Employee', component: EmployeeComponent},
  {path: 'ViewR', component: ViewrequestsComponent},
  {path: 'NewR', component: NewrequestComponent},
  {path: 'Profile', component: ProfileComponent},


]




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
