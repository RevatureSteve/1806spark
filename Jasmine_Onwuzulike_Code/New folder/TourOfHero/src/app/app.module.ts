import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeroeesComponent } from './heroees/heroees.component';

import { FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    HeroeesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
