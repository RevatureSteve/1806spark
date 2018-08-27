import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';


export class Hero {
  id: number;
  name: string;
}


@Component({
  selector: 'app-root',
  template: `<h1>{{title}}</h1><h2>{{hero.name}} details!</h2>
            <div><label>id: </label>{{hero.id}}</div>
            <div><label>name: </label><input [(ngModule)]= "hero.name" placeholder = "name"></div>`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Tour of heroes';
  hero: Hero = {
    id: 1,
    name: 'Windstorm',
  };
}


