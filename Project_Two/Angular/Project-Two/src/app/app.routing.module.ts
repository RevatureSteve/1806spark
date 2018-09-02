// Used for navigation, like href
import { RecipeComponent } from './Components/recipe/recipe.component';
import { CartComponent } from './Components/cart/cart.component';
import { UserDashboardComponent } from './Pages/user-dashboard/user-dashboard.component';
import { LoginComponent } from './Pages/login/login.component';
import { DashboardComponent } from './Pages/dashboard/dashboard.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: DashboardComponent},
    {path: 'login', component: LoginComponent},
    {path: 'userDash', component: UserDashboardComponent},
    {path: 'cart', component: CartComponent},
    {path: 'recipe', component: RecipeComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
