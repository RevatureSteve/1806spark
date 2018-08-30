import { MainComponent } from './main/main.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ManagerComponent } from './manager/manager.component';
import { EmployeeComponent } from './employee/employee.component';
import { ViewrequestsComponent } from './viewrequests/viewrequests.component';
import { NewrequestComponent } from './newrequest/newrequest.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { OneReimbursementComponent } from './one-reimbursement/one-reimbursement.component'
import { ViewusersComponent} from './viewusers/viewusers.component'
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';

export const routes: Routes = [
  {path: '', redirectTo: 'Login', pathMatch: 'full'},
  {path: 'home', component: MainComponent},
  {path: 'Manager', component: ManagerComponent},
  {path: 'Employee', component: EmployeeComponent},
  {path: 'ViewR', component: ViewrequestsComponent},
  {path: 'NewR', component: NewrequestComponent},
  {path: 'Profile', component: ProfileComponent},
  {path: 'Login', component: LoginComponent},
  {path: 'Onereimbursement', component: OneReimbursementComponent},
  {path: 'ViewU', component: ViewusersComponent},
  {path: 'EditU', component: UpdateprofileComponent}


]




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
