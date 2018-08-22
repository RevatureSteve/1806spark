import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LoginComponent } from './pages/login/login.component';
import { AddTaskComponent } from './pages/add-task/add-task.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '../../node_modules/@angular/core';

/*
providing a path every time.
2 elements of this:
-path
-component

*/


export const routes: Routes = [
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    { path: 'dashboard', component: DashboardComponent },
    { path: 'login', component: LoginComponent },
    { path: 'addTask', component: AddTaskComponent }
];

@NgModule({
    imports:
        [
            RouterModule.forRoot(routes)
        ],
    exports: [RouterModule]
    })



export class AppRoutingModule { }
