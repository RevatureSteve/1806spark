import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BigBoxComponent } from './big-box/big-box.component';
import { SmallBoxComponent } from './small-box/small-box.component';

@NgModule({
  declarations: [
    AppComponent,
    BigBoxComponent,
    SmallBoxComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
