import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MessagesComponent } from './messages/messages.component';
import { CurrentDayComponent } from './current-day/current-day.component';

@NgModule({
  declarations: [
    AppComponent,
    MessagesComponent,
    CurrentDayComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
