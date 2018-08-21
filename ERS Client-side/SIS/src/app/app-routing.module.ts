import { MangComponent } from './mang/mang.component';
import { HomeComponent } from './home/home.component';
import { EmpComponent } from './emp/emp.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';



const routes : Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component:LoginComponent },
  {path: 'emp', component: EmpComponent},
  {path: 'mang', component: MangComponent},

]



@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
