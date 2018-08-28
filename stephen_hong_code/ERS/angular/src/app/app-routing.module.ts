
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';
import { CreateReimbursementComponent } from './components/create-reimbursement/create-reimbursement.component';
import { LandingComponent } from './components/landing/landing.component';
import { ManagerReimbursementComponent } from './components/manager-reimbursement/manager-reimbursement.component';
import { ProfileComponent } from './components/profile/profile.component';

const ROUTES: Routes = [
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    {
        path: 'register',
        component: RegisterComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'landing',
        component: LandingComponent
    },
    {
        path: 'create-reimbursement',
        component: CreateReimbursementComponent
    },
    {
        path: 'manager',
        component: ManagerReimbursementComponent
    },
    {
        path: 'profile',
        component: ProfileComponent
    }
];

@NgModule({
    imports: [ RouterModule.forRoot(ROUTES)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
