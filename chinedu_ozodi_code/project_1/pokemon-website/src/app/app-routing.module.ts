import { PokemonComponent } from './pages/pokemon/pokemon.component';
import { ReimbursementsComponent } from './pages/reimbursements/reimbursements.component';
import { AdminComponent } from './admin/admin.component';
import { PokeBagComponent } from './poke-bag/poke-bag.component';
import { LoginComponent } from './login/login.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { MainComponent } from './main/main.component';
import { ManageReimbursementsComponent } from './pages/manage-reimbursements/manage-reimbursements.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { EmployeesComponent } from './pages/employees/employees.component';

const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: '', component: WelcomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'main', component: MainComponent},
  {path: 'pokebag', component: PokeBagComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'reimbursements', component: ReimbursementsComponent},
  {path: 'manage-reimbursements', component: ManageReimbursementsComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'employees', component: EmployeesComponent},
  {path: 'pokemon', component: PokemonComponent},
  {path: '**', redirectTo: 'welcome'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],

  exports: [RouterModule]
})
export class AppRoutingModule { }
