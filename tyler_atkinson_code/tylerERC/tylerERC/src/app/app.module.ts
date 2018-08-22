import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule } from '@angular/forms'; 

import { AppRoutingModule } from './app-routing.module';
// import { HomeComponent } from './home/home.component';
import { MainComponent } from './main/main.component';
import { ManagerComponent } from './manager/manager.component';
import { EmployeeComponent } from './employee/employee.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    // HomeComponent,
    MainComponent,
    ManagerComponent,
    EmployeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
