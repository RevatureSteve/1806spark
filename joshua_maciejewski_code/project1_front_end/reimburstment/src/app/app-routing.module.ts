import { ManagerviewemployeesComponent } from './managerviewemployees/managerviewemployees.component';
import { ManagerresolvedComponent } from './managerresolved/managerresolved.component';
import { ManagerrequestsbyidComponent } from './managerrequestsbyid/managerrequestsbyid.component';
import { ManagerpendingComponent } from './managerpending/managerpending.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { EmployeeresolvedComponent } from './employeeresolved/employeeresolved.component';
import { EmployeependingComponent } from './employeepending/employeepending.component';
import { ManagerhomeComponent } from './managerhome/managerhome.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { EmployeehomeComponent } from './employeehome/employeehome.component';
import { NewrequestComponent } from './newrequest/newrequest.component';
import { LogoutComponent } from './logout/logout.component';

export const routes: Routes = [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'employeehome', component: EmployeehomeComponent},
    {path: 'managerhome', component: ManagerhomeComponent},
    {path: 'newrequest', component: NewrequestComponent},
    {path: 'employeepending', component: EmployeependingComponent},
    {path: 'employeeresolved', component: EmployeeresolvedComponent},
    {path: 'editprofile', component: EditprofileComponent},
    {path: 'managerpending', component: ManagerpendingComponent},
    {path: 'managerrequestsbyid/:id', component: ManagerrequestsbyidComponent},
    {path: 'managerresolved', component: ManagerresolvedComponent},
    {path: 'managerviewemployees', component: ManagerviewemployeesComponent},
    {path: 'logout', component: LogoutComponent},
    {path: '**', redirectTo: 'login'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}