import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './/app-routing.module';
import { ProfileComponent } from './profile/profile.component';
import { EmployeeReimbursementComponent } from './employee-reimbursement/employee-reimbursement.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ReimbursementsService } from './reimbursements.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent,
    EmployeeReimbursementComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [ReimbursementsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
