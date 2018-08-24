import { NgModule } from '@angular/core';
import { AddTaskComponent } from './app/add-task/add-task.component';
import { LoginComponent } from './app/login/login.component';
import { DashboardComponent } from './app/dashboard/dashboard.component';
import { Routes, RouterModule, Router} from '@angular/router'


export const routes : Routes = [
    {path: 'dashboard', component: DashboardComponent},
    {path: 'login', component: LoginComponent},
    {path: 'addTask', component: AddTaskComponent },
    {path: '**', component: LoginComponent}

];

@NgModule ({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]


})

export class AppRoutingModule { }






