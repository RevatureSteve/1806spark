import { AddtaskComponent } from './addtask/addtask.component';
import { Component } from '@angular/core';
import { DashboardComponent } from './dashboard/dashboard.component';
import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';

export routes: Routes = [
    
    { path: 'dashboard', component: DashboardComponent},
    { path: 'login', component: LoginComponent},
    { path: 'addTask', component: AddtaskComponent}
]

export class AppRoutingModule {}