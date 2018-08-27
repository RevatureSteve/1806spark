import { ViewUserResolvedComponent } from './pages/view-user-resolved/view-user-resolved.component';
import { SubmitReimbursementsComponent } from './pages/submit-reimbursements/submit-reimbursements.component';
import { ViewReimbursementsComponent } from './pages/view-reimbursements/view-reimbursements.component';
import { ManagerHomeComponent } from './pages/manager-home/manager-home.component';
import { EmployeeHomeComponent } from './pages/employee-home/employee-home.component';
import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

export const routes: Routes = [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'empHome', component: EmployeeHomeComponent},
    {path: 'manHome', component: ManagerHomeComponent},
    {path: 'viewReimb', component: ViewReimbursementsComponent},
    {path: 'submitReimb', component: SubmitReimbursementsComponent},
    {path: 'viewUserResolve', component: ViewUserResolvedComponent},
    {path: '**', redirectTo: 'login'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
