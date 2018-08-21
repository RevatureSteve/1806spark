import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EmployeeComponent } from './employee/employee.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule} from '@angular/common/http';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ReimbursementListComponent } from './reimbursement-list/reimbursement-list.component';
import { AppRoutingModule } from './/app-routing.module';
import { SubmitComponent } from './submit/submit.component';
import { ReimbursementDetailsComponent } from './reimbursement-details/reimbursement-details.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    NavbarComponent,
    UpdateUserComponent,
    ReimbursementListComponent,
    SubmitComponent,
    ReimbursementDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
