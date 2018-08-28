import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';

import { AppComponent } from './app.component';
import { HttpTestService } from './services/http-test.service';
import { RegisterComponent } from './components/register/register.component';
import { AppRoutingModule } from './app-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from './services/user.service';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';
import { ReimbursementService } from './services/reimbursement.service';
import { CreateReimbursementComponent } from './components/create-reimbursement/create-reimbursement.component';
import { LandingComponent } from './components/landing/landing.component';
import { ManagerReimbursementComponent } from './components/manager-reimbursement/manager-reimbursement.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { ProfileComponent } from './components/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent,
    ReimbursementsComponent,
    CreateReimbursementComponent,
    LandingComponent,
    ManagerReimbursementComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    DataTablesModule,
    AngularFontAwesomeModule
  ],
  providers: [
    HttpTestService,
    UserService,
    ReimbursementService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
