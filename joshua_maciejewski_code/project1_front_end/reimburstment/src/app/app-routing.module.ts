import { ManagerhomeComponent } from './managerhome/managerhome.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { EmployeehomeComponent } from './employeehome/employeehome.component';

export const routes: Routes = [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'employeehome', component: EmployeehomeComponent},
    {path: 'managerhome', component: ManagerhomeComponent},
    {path: '**', redirectTo: 'login'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}