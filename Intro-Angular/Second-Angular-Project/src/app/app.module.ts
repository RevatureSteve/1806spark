import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ClickerComponent } from './clicker/clicker.component';
import { NavComponent } from './nav/nav.component';
import { MainComponent } from './main/main.component';
import { ChuckNorrisComponent } from './chuck-norris/chuck-norris.component';

@NgModule({
  declarations: [
    AppComponent,
    ClickerComponent,
    NavComponent,
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
