import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Input } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AppRoutingModule } from './/app-routing.module';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PokeBagComponent } from './poke-bag/poke-bag.component';
import { AdminComponent } from './admin/admin.component';
import { PokemonCardComponent } from './useful_components/pokemon-card/pokemon-card.component';
import { ReimbursementsComponent } from './pages/reimbursements/reimbursements.component';
import { ReimbursementCardComponent } from './useful_components/reimbursement-card/reimbursement-card.component';
import { ManageReimbursementsComponent } from './pages/manage-reimbursements/manage-reimbursements.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { EmployeesComponent } from './pages/employees/employees.component';
import { ProfileCardComponent } from './pages/employees/profile-card/profile-card.component';
import { PokemonComponent } from './pages/pokemon/pokemon.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    WelcomeComponent,
    LoginComponent,
    MainComponent,
    PokeBagComponent,
    AdminComponent,
    PokemonCardComponent,
    ReimbursementsComponent,
    ReimbursementCardComponent,
    ManageReimbursementsComponent,
    ProfileComponent,
    EmployeesComponent,
    ProfileCardComponent,
    PokemonComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgbModule.forRoot(),
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
