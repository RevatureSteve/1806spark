// Used for navigation, like href
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersInformationComponent } from './pages/users-information/users-information.component';
import { ReimbursementInformationComponent } from './pages/reimbursement-information/reimbursement-information.component';
import { ApprovedReimbInfoComponent } from './pages/approved-reimb-info/approved-reimb-info.component';
import { PendingReimbInfoComponent } from './pages/pending-reimb-info/pending-reimb-info.component';
import { DeniedReimbInfoComponent } from './pages/denied-reimb-info/denied-reimb-info.component';
import { LoginComponent } from './pages/login/login.component';
import { ManagersComponent } from './pages/managers/managers.component';
import { UsersComponent } from './pages/users/users.component';

const routes: Routes = [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'info', component: UsersInformationComponent},
    {path: 'login', component: LoginComponent},
    {path: 'reimb/approved', component: ApprovedReimbInfoComponent},
    {path: 'reimb/pending', component: PendingReimbInfoComponent},
    {path: 'reimb/denied', component: DeniedReimbInfoComponent},
    {path: 'reimb/info', component: ReimbursementInformationComponent},
    {path: 'overseer', component: ManagersComponent},
    {path: 'dweller', component: UsersComponent},
    {path: '**', redirectTo: 'login'}

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
