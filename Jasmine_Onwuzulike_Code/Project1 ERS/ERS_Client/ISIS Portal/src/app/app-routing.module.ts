import { UploadFileComponent } from './upload-file/upload-file.component';
import { NewPasswordComponent } from './new-password/new-password.component';


import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeHomeComponent } from './views/employee-home/employee-home.component';
import { ManagerHomeComponent } from './views/manager-home/manager-home.component';
import { AgentProfileComponent } from './views/agent-profile/agent-profile.component';
import { AgentMissionsComponent } from './views/agent-missions/agent-missions.component';
import { AgentReimbursementsComponent } from './views/agent-reimbursements/agent-reimbursements.component';
import { AllReimbursementsComponent } from './views/all-reimbursements/all-reimbursements.component';
import { AllAgentsComponent } from './views/all-agents/all-agents.component';
import { NewReimbursemetComponent } from './new-reimbursemet/new-reimbursemet.component';
import { UpdateReimbursementComponent } from './update-reimbursement/update-reimbursement.component';



//Navigation paths.
const routes : Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component:LoginComponent },
  {path: 'employee', component: EmployeeHomeComponent},
  {path: 'manager', component: ManagerHomeComponent},
  {path: 'agent/profile', component: AgentProfileComponent},
  {path: 'agent/missions', component: AgentMissionsComponent},
  {path: 'agnet/reimbursements', component: AgentReimbursementsComponent},
  {path: 'reimbursements', component: AllReimbursementsComponent },
  {path: 'agents', component: AllAgentsComponent},
  {path: 'password', component: NewPasswordComponent},
  {path: 'new/reimbursement', component: NewReimbursemetComponent},
  {path: 'update' , component: UpdateReimbursementComponent},
  {path: 'upload', component: UploadFileComponent},
  {path: '**', component: LoginComponent}
 
]



@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
