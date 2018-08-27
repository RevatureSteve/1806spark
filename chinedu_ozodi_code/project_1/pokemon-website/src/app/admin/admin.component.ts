import { PokemonService } from '../services/pokemon.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private pokemon: PokemonService) { }

  ngOnInit() {
  }

  scrapePokemon() {
    const allPokemon = [];
    for (let i = 0; i < 200; i++) {
      allPokemon.push(i + 1);
    }
    this.pokemon.scrapePokemon(2, allPokemon);
    // this.pokemon.scrapePokemon(0, [2]);
  }

}
