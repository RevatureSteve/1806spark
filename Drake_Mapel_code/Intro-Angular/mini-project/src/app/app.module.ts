import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import { WorldComponent } from './world/world.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    WorldComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
