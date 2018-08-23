import { RevComponent } from './pages/rev/rev.component';
import { AddTodoComponent } from './pages/add-todo/add-todo.component';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    {path: '', redirectTo: 'rev', pathMatch: 'full'},
    {path: 'rev', component: RevComponent},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'login', component: LoginComponent},
    {path: 'addTodo', component: AddTodoComponent},
    {path: '**', redirectTo: 'rev'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}
