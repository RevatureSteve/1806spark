import { Pokemon } from './pokemon';
export class LocalTile {
    tileId: number;
    tileParentId: number;
    tileName: string;
    x: number;
    y: number;
    tileTypeId: number;
    tileType: string;
    pokemon: Pokemon[];
}
