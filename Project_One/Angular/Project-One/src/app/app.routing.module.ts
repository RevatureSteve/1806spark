// Used for navigation, like href
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersInformationComponent } from './pages/users-information/users-information.component';
import { ReimbursementInformationComponent } from './pages/reimbursement-information/reimbursement-information.component';
import { ApprovedReimbInfoComponent } from './pages/approved-reimb-info/approved-reimb-info.component';
import { PendingReimbInfoComponent } from './pages/pending-reimb-info/pending-reimb-info.component';
import { DeniedReimbInfoComponent } from './pages/denied-reimb-info/denied-reimb-info.component';
import { LoginBoxComponent } from './components/login-box/login-box.component';

const routes: Routes = [
    {
        path: '',
        component: LoginBoxComponent
    },
    {
        path: '',
        component: UsersInformationComponent
    },
    {
        path: '',
        component: ApprovedReimbInfoComponent
    },
    {
        path: '',
        component: PendingReimbInfoComponent
    },
    {
        path: '',
        component: DeniedReimbInfoComponent
    },
    {
        path: '',
        component: ReimbursementInformationComponent
    }
];
