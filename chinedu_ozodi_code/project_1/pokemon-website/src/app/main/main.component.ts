import { LoginService } from './../services/login.service';
import { PokemonService } from './../services/pokemon.service';
import { World } from './../models/world';
import { WorldService } from './../services/world.service';
import { Component, OnInit } from '@angular/core';
import { WorldTile } from '../models/world_tile';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  world: World;
  map: WorldTile[][] = [];

  constructor(
    private worldService: WorldService,
    private pokemonService: PokemonService,
    private loginService: LoginService
  ) {

    // Get world map from db
    this.worldService.getWorld().subscribe( world => {
      console.log(world);
      this.world = world;
      this.generateWorldTiles();
    });
    // console.log(this.map);
  }

  generateWorldTiles(): void {
    console.log('[LOG] main component - generating world tiles');
    for (let y = 0; y < this.world.length; y++) {
      this.map.push([]);
      for (let x = 0; x < this.world.width; x++) {
      // generate a tile object
      this.map[y].push(this.world.worldTiles.find( t => t.x === x && t.y === y));
      }
    }
    console.log('[LOG] generation complete');
  }

  caughtPokemon() {
    // update pokemon to belong to trainer
    this.pokemonService.pokemonBattle.trainerId = this.loginService.currentTrainer.trainerId;
    this.pokemonService.pokemonBattle.ltId = null;
    this.pokemonService.pokemonBattle.statusId = 2;
    this.pokemonService.updatePokemon(this.pokemonService.pokemonBattle).subscribe(
      done => {
        this.loginService.getTrainerPokemon();
      }
    );
    this.pokemonService.pokemonBattle = null;
  }

  ngOnInit() {
    if (!this.loginService.currentUser) {
      this.loginService.checkSession();
    }
  }

}
