import { Component, OnInit } from '@angular/core';
import { Hero} from '../hero';
import { HEROES} from '../mock-heroes';


@Component({
  selector: 'app-heroees',
  templateUrl: './heroees.component.html',
  styleUrls: ['./heroees.component.css']
})
export class HeroeesComponent implements OnInit {
  hero : Hero = {
    id: 1,
    name: 'Windstorm'
  }
  heroes = HEROES;
  constructor() { }

  ngOnInit() {
  }



}
