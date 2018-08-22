import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ComponentComponent } from './component/component.component';
import { HelloComponent } from './hello/hello.component';
import { ByeComponent } from './bye/bye.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentComponent,
    HelloComponent,
    ByeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
