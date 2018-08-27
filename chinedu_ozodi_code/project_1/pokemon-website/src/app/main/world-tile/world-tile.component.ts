import { WorldTile } from './../../models/world_tile';
import { Component, OnInit, Input } from '@angular/core';
import { PokemonService } from '../../services/pokemon.service';

@Component({
  selector: 'app-world-tile',
  templateUrl: './world-tile.component.html',
  styleUrls: ['./world-tile.component.css']
})
export class WorldTileComponent implements OnInit {

  @Input()
  worldTile: WorldTile;

  constructor(private pokemonService: PokemonService) { }

  ngOnInit() {
  }

  searchPokemon() {
    // Get pokemon from db
    const x = Math.floor(Math.random() * this.worldTile.width);
    const y = Math.floor(Math.random() * this.worldTile.length);
    console.log(`searching for pokemon in world Tile: ${this.worldTile.tileId}, position: ${x},${y}`);
    this.pokemonService.getPokemonByLocalTilePosition(this.worldTile.tileId, x, y).subscribe( pokemon => {
      console.log('[LOG] world-tile component done searching ' + pokemon);
      if (pokemon) {
        this.pokemonService.pokemonBattle = pokemon[0];
      }
    });
  }
}
