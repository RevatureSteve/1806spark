import { RouterModule, Routes } from '@angular/router';
import { ClickerComponent } from './clicker/clicker.component';


export const routes: Routes = [
{path: '', redirectTo: '/home'},
{path: 'home', component: AppComponent},
{path: 'dashboard', component: ClickerComponent}
];

@NgModule({

})