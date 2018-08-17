import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AnotherNavBarComponent } from './another-nav-bar/another-nav-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AnotherNavBarComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
