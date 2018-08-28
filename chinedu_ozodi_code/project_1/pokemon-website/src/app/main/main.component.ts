import { UserService } from './../services/user.service';
import { Pokemon } from './../models/pokemon';
import { Observable } from 'rxjs';
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
  battleStatus: string;

  constructor(
    private worldService: WorldService,
    private pokemonService: PokemonService,
    private loginService: LoginService,
    private userService: UserService
  ) { }

  ngOnInit() {
    if (!this.loginService.currentUser) {
      this.loginService.checkSession();
    }

    // Get world map from db
    this.worldService.getWorld().subscribe(world => {
      console.log(world);
      this.world = world;
      this.generateWorldTiles();
    });
  }

  generateWorldTiles(): void {
    console.log('[LOG] main component - generating world tiles');
    for (let y = 0; y < this.world.length; y++) {
      this.map.push([]);
      for (let x = 0; x < this.world.width; x++) {
        // generate a tile object
        this.map[y].push(this.world.worldTiles.find(t => t.x === x && t.y === y));
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
  }

  searchPokemon() {
    const x = Math.floor(Math.random() * this.world.width);
    const y = Math.floor(Math.random() * this.world.length);
    console.log(`Searching ${this.map[y][x].tileId}: ${x},${y}`);
    this.battleStatus = 'Searching...';
    this.searchPokemonTile(this.map[y][x]).subscribe(pokemon => {
      console.log('[LOG] main component done searching ' + pokemon);
      this.battleStatus = null;
      if (pokemon) {
        this.pokemonService.pokemonBattle = pokemon[0];
      }
    });
  }
  public searchPokemonTile(worldTile: WorldTile): Observable<Pokemon[]> {
    // Get pokemon from db
    const x = Math.floor(Math.random() * worldTile.width);
    const y = Math.floor(Math.random() * worldTile.length);
    console.log(`searching for pokemon in world Tile: ${worldTile.tileId}, position: ${x},${y}`);
    return this.pokemonService.getPokemonByLocalTilePosition(worldTile.tileId, x, y);
  }

  acknowledge() {
    this.battleStatus = null;
    this.pokemonService.pokemonBattle = null;
  }

  buyBall() {
    if (this.loginService.currentTrainer.candyCount >= 10) {
      this.loginService.currentTrainer.pokeballCount++;
      this.loginService.currentTrainer.candyCount -= 10;
      this.userService.updateTrainer(this.loginService.currentTrainer).subscribe( done => {
        this.loginService.getTrainer();
      });
    }

  }

  throwBall() {
    this.battleStatus = 'waiting...';
    this.loginService.currentTrainer.pokeballCount--;
    this.userService.updateTrainer(this.loginService.currentTrainer).subscribe(done => {
      if (Math.random() < .1) {
        this.loginService.getTrainer();
        this.throwResult();
      } else {
        this.wait();
      }
    });
  }

  wait() {
    this.userService.updateTrainer(this.loginService.currentTrainer).subscribe(done => {
      if (Math.random() < .15) {
        this.loginService.getTrainer();
        this.throwResult();
      } else {
        this.wait();
      }
    });
  }

  throwResult() {
    if (Math.random() < .8) {
      this.battleStatus = 'Caught!';
      this.caughtPokemon();
    } else {
      this.battleStatus = 'Pokemon escaped...try again';
    }
  }
}
