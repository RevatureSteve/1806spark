import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AppRoutingModule } from './/app-routing.module';
import { ManagerComponent } from './pages/manager/manager.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { LoginComponent } from './pages/login/login.component';
import { EmpComponent } from './models/emp/emp.component';
import { MgrComponent } from './models/mgr/mgr.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ManagerComponent,
    EmployeeComponent,
    LoginComponent,
    EmpComponent,
    MgrComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
