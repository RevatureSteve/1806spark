import { ChuckNorrisComponent } from './chuck-norris/chuck-norris.component';
import { MainComponent } from './main/main.component';
import { ClickerComponent } from './clicker/clicker.component';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';



export const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: MainComponent},
  {path: 'dashboard', component: ClickerComponent},
  {path: 'chuck-norris', component: ChuckNorrisComponent},
  {path: '**', redirectTo: 'home'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})

export class AppRoutingModule {}
