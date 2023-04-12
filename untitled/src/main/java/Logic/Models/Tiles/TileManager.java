package Logic.Models.Tiles;

import Graphic.Models.GuiGameState;
import Graphic.Models.Tiles.GuiTile;
import Logic.Models.LogicGameState;

public class TileManager {

    public int screenCols = 26;
    public int screenRows = 15;
    public int worldCols = 26 * 4;
    public int worldRows = 15;
    public int topLeftColInWorld = 0;
    LogicGameState logicGameState;
    Tile[] tiles;
    public int[][] mapTileNum;

    public TileManager() {
    }

    public TileManager(LogicGameState logicGameState){
        this.logicGameState = logicGameState;
        tiles = new Tile[10];
        loadTiles();
    }
    public void loadTiles() {
        tiles[0] = new Tile(false,0);
        tiles[1] = new Tile(true,1);
        tiles[2] = new Tile(true,2);
        tiles[3] = new Tile(true,3);
        tiles[4] = new Tile(true,4);
        tiles[5] = new Tile(true,5);
        tiles[6] = new Tile(true,6);
        tiles[7] = new Tile(false,7);
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }
}
