import { LocalTile } from './local_tile';
export class WorldTile {
    tileId: number;
    tileParentId: number;
    tileName: string;
    x: number;
    y: number;
    tileTypeId: number;
    tileType: string;
    length: number;
    width: number;
    localTiles: LocalTile[];
}
