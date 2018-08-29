import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginPageComponent } from './login-page/login-page.component';
import { RouterModule, Routes } from '@angular/router';
import { EmployeePageComponent } from './employee-page/employee-page.component';



const ROUTES: Routes = [

  {
    path: '', redirectTo: 'login', pathMatch: 'full'
  },

  {
      path: 'login',
      component: LoginPageComponent
  },

  {
      path: 'dashboard',
      component: EmployeePageComponent
  }];

//   {
//       path: 'register',
//       component: RegisterComponent
//   },

//   {
//       path: 'calendar',
//       component: CalendarComponent
//   },

//   {
//       path: 'curriculum/editor',
//       component: CurriculumEditorComponent
//   },

//   {
//       path: 'boom',
//       component: BoomComponent
//   },
//   {
//       path: 'curriculum/editor',
//       component: DialogViewComponent
//   },
//   {
//       path: '',
//       pathMatch: 'full',
//       redirectTo: 'dashboard'
//   }
// ];

@NgModule({
  imports: [ RouterModule.forRoot(ROUTES) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {


 }
