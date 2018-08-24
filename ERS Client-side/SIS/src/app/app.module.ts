import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';
import { FormsModule } from '@angular/forms';
import { AgentProfileComponent } from './agent-profile/agent-profile.component';
import { AgentMissionsComponent } from './agent-missions/agent-missions.component';
import { AgentReimbursementsComponent } from './agent-reimbursements/agent-reimbursements.component';
import { AllAgentsComponent } from './all-agents/all-agents.component';
import { AllReimbursementsComponent } from './all-reimbursements/all-reimbursements.component';


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
    AllReimbursementsComponent
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
