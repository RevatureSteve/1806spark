import { Component, OnInit} from '@angular/core';

import { PokemonService } from '../../services/pokemon.service';

import { Pokemon } from '../../models/pokemon.model';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {
  title = 'HTTP';
  documentation = 'https://angular.io/guide/http';

  //Injecting the service
  constructor(private pokemonService: PokemonService) {}

  public pokemon: Pokemon = new Pokemon(5,'');

  getPokemonInformation(): void {
      this.pokemonService.fetchPokemonInformation(this.pokemon.id)
      .subscribe(
        pokemon => this.pokemon = pokemon,
        error => console.log(`Error: ${ error }`)
      );
  }

  //If you want to do it when the component gets created
  ngOnInit() {
    this.getPokemonInformation();
  }
}