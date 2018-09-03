import { ReimbursementServiceService } from './services/reimbursement-service.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { ManagerReimbursementsComponent } from './manager-reimbursements/manager-reimbursements.component';
import { FormsModule } from '@angular/forms';
import { EmployeeHomepageComponent } from './employee-homepage/employee-homepage.component';
import { ManagerHomepageComponent } from './manager-homepage/manager-homepage.component';
import { CreateReimbursementComponent } from './create-reimbursement/create-reimbursement.component';
import { AllReimbursementsComponent } from './all-reimbursements/all-reimbursements.component';
import { LogouthpComponent } from './logouthp/logouthp.component';
import { UpdateUsersComponentComponent } from './update-users-component/update-users-component.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    ManagerReimbursementsComponent,
    EmployeeHomepageComponent,
    ManagerHomepageComponent,
    CreateReimbursementComponent,
    AllReimbursementsComponent,
    LogouthpComponent,
    UpdateUsersComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
