import { AppComponent } from './app.component';
import { ClickerComponent } from './clicker/clicker.component';
import { RouterModule, Routes} from '@angular/router';
import { NgModule } from '@angular/core';


export const routes: Routes = [
    {path: '', redirectTo: 'home'},
    {path: 'home', component: AppComponent},
    {path: 'dashboard', component: ClickerComponent},
    {path: 'chuck-norris', redirectTo: 'home'},
    {path: '**', redirectTo: 'home'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}
