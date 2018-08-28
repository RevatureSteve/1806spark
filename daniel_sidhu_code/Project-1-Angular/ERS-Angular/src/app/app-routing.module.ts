import { ManagerApprovedReimbursementsComponent } from './manager-approved-reimbursements/manager-approved-reimbursements.component';
import { ManagerAllReimbursementsComponent } from './manager-all-reimbursements/manager-all-reimbursements.component';
import { ManagerProfileComponent } from './manager-profile/manager-profile.component';
import { ManagerViewEmployeesComponent } from './manager-view-employees/manager-view-employees.component';
import { EmployeeComponent } from './employee/employee.component';
import { ManagerComponent } from './manager/manager.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { EmployeeProfileComponent } from './employee-profile/employee-profile.component';
import { ManagerPendingReimbursementsComponent } from './manager-pending-reimbursements/manager-pending-reimbursements.component';
import { NewReimbursementComponent } from './new-reimbursement/new-reimbursement.component';


export const routes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'manager', component: ManagerComponent},
    {path: 'employee', component: EmployeeComponent},
    {path: 'manager/profile', component: ManagerProfileComponent},
    {path: 'employee/profile', component: EmployeeProfileComponent},
    {path: 'manager/reimbursementlist', component: ManagerAllReimbursementsComponent},
    {path: 'manager/pending/reimbursementlist', component: ManagerPendingReimbursementsComponent},
    {path: 'manager/approved/reimbursementlist', component: ManagerApprovedReimbursementsComponent},
    {path: 'manager/employeeslist', component: ManagerViewEmployeesComponent},
    {path: 'employee/newReimbursement', component: NewReimbursementComponent},
    {path: '**', redirectTo: 'home'}
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}
