import { Component, OnInit } from '@angular/core';
import {Hero} from '../Hero';
import { HEROES } from '../mock-heroes';
@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

 hero: Hero = {
   id : 1,
   name : "Windstorm"
 };

 heroes = HEROES;

 selectedHero: Hero;

 onSelect(hero: Hero): void {
  this.selectedHero = hero;
}
 
  constructor() { }

  ngOnInit() {
  }

}
