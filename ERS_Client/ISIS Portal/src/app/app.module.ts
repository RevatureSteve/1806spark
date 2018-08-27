
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { EmployeeHomeComponent } from './views/employee-home/employee-home.component';
import { ManagerHomeComponent } from './views/manager-home/manager-home.component';
import { AgentProfileComponent } from './views/agent-profile/agent-profile.component';
import { AgentMissionsComponent } from './views/agent-missions/agent-missions.component';
import { AgentReimbursementsComponent } from './views/agent-reimbursements/agent-reimbursements.component';
import { AllAgentsComponent } from './views/all-agents/all-agents.component';
import { AllReimbursementsComponent } from './views/all-reimbursements/all-reimbursements.component';
import { NewPasswordComponent } from './new-password/new-password.component';
import { NewReimbursemetComponent } from './new-reimbursemet/new-reimbursemet.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    EmployeeHomeComponent,
    ManagerHomeComponent,
    AgentProfileComponent,
    AgentMissionsComponent,
    AgentReimbursementsComponent,
    AllAgentsComponent,
    AllReimbursementsComponent,
    NewPasswordComponent,
    NewReimbursemetComponent,
 

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
