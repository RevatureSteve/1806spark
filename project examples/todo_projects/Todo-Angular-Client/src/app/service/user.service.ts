import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private httpClient: HttpClient) { }


}



// getPokemon(id: number): void {
//   this.client.get(`https://pokeapi.co/api/v2/pokemon/${id}`)
//     .subscribe(
//       (succ) => {
//         this.pokemon = succ;
//         console.log(succ);
//       },
//       (err) => {
//         alert('failed to retreive pokemon with id ' + id);
//       }
//     );
// }
