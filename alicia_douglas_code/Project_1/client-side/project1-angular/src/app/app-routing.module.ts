import { SingleEmployeeViewComponent } from './single-employee-view/single-employee-view.component';
import { MainManagerComponent } from './main-manager/main-manager.component';
import { MainComponent } from './main/main.component';
import { EmployeeReimbursementComponent } from './employee-reimbursement/employee-reimbursement.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewReimbursementComponent } from './new-reimbursement/new-reimbursement.component';


const routes: Routes = [
  {path: 'home', component: MainComponent},
  {path: 'home/sorcerer', component: MainManagerComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'new-reimbursement', component: NewReimbursementComponent},
  {path: 'employee/:id', component: SingleEmployeeViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
