import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MarioComponent } from './mario/mario.component';
import { LuigiComponent } from './luigi/luigi.component';

@NgModule({
  declarations: [
    AppComponent,
    MarioComponent,
    LuigiComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
