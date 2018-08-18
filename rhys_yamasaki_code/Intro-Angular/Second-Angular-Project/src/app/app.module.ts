import { AppRoutingModule } from './app-routing-module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ClickerComponent } from './clicker/clicker.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MainComponent } from './main/main.component';
import { ChuckNorrisComponent } from './chuck-norris/chuck-norris.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ClickerComponent,
    NavbarComponent,
    MainComponent,
    ChuckNorrisComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [], // services
  bootstrap: [AppComponent]
})
export class AppModule { }
