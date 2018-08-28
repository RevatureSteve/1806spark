import { ManageReimbursementsComponent } from './pages/manage-reimbursements/manage-reimbursements.component';
import { ViewAllUserReimbComponent } from './pages/view-all-user-reimb/view-all-user-reimb.component';
import { ViewAllResolvedComponent } from './pages/view-all-resolved/view-all-resolved.component';
import { ViewAllPendingComponent } from './pages/view-all-pending/view-all-pending.component';
import { ViewEmployeesComponent } from './pages/view-employees/view-employees.component';
import { ProfileComponent } from './pages/profile/profile.component';
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
    {path: 'profile', component: ProfileComponent},
    {path: 'viewUsers', component: ViewEmployeesComponent},
    {path: 'manageReimb', component: ManageReimbursementsComponent},
    {path: 'viewAllPendingReimb', component: ViewAllPendingComponent},
    {path: 'viewAllResolvedReimb', component: ViewAllResolvedComponent},
    {path: 'viewAllUserReimb', component: ViewAllUserReimbComponent},
    {path: '**', redirectTo: 'login'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
