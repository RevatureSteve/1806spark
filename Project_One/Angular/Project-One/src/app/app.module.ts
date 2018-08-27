import { AppRoutingModule } from './app.routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { ReimbursementComponent } from './pages/reimbursement/reimbursement.component';
import { UsersComponent } from './pages/users/users.component';
import { ManagersComponent } from './pages/managers/managers.component';
import { UsersInformationComponent } from './pages/users-information/users-information.component';
import { ReimbursementInformationComponent } from './pages/reimbursement-information/reimbursement-information.component';
import { ApprovedReimbInfoComponent } from './pages/approved-reimb-info/approved-reimb-info.component';
import { PendingReimbInfoComponent } from './pages/pending-reimb-info/pending-reimb-info.component';
import { DeniedReimbInfoComponent } from './pages/denied-reimb-info/denied-reimb-info.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginBoxComponent } from './components/login-box/login-box.component';
import { CreateReimbComponent } from './pages/create-reimb/create-reimb.component';
import { UpdateUserComponent } from './pages/update-user/update-user.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ReimbursementComponent,
    UsersComponent,
    ManagersComponent,
    UsersInformationComponent,
    ReimbursementInformationComponent,
    ApprovedReimbInfoComponent,
    PendingReimbInfoComponent,
    DeniedReimbInfoComponent,
    NavbarComponent,
    LoginBoxComponent,
    CreateReimbComponent,
    UpdateUserComponent
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
