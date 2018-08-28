import { PokemonService } from './../../services/pokemon.service';
import { LoginService } from './../../services/login.service';
import { Reimbursement } from './../../models/reimbursement';
import { Component, OnInit, Input } from '@angular/core';
import { Pokemon } from '../../models/pokemon';
import { ReimbursementService } from '../../services/reimbursement.service';

@Component({
  selector: 'app-pokemon-card',
  templateUrl: './pokemon-card.component.html',
  styleUrls: ['./pokemon-card.component.css']
})
export class PokemonCardComponent implements OnInit {

  @Input()
  pokemon: Pokemon;

  constructor(
    private reimbursementService: ReimbursementService,
    private loginService: LoginService,
    private pokemonService: PokemonService
  ) { }

  ngOnInit() {
  }

  createReimbursement() {
    const reimb = new Reimbursement();
    reimb.amt = this.pokemon.experience;
    reimb.description = 'requesting reimbursement for ' + this.pokemon.name;
    reimb.empUId = this.loginService.currentUser.uId;
    reimb.rqTypeId = this.pokemon.pokeId;
    reimb.rqType = this.pokemon.name;
    reimb.timeSubmission = Date.now();
    reimb.rqStatusId = 1;
    this.reimbursementService.createReimbursement(reimb).subscribe( done => {
      console.log('[LOG] pokemon-card reimbursement complete');
      this.pokemon.statusId = 3;
      this.pokemonService.updatePokemon(this.pokemon).subscribe( complete => {
        this.loginService.getTrainerPokemon();
      });
    });
  }

  done() {
    this.pokemon.statusId = 4;
    this.pokemonService.updatePokemon(this.pokemon).subscribe( complete => {
      this.loginService.getTrainerPokemon();
    });
  }

}
