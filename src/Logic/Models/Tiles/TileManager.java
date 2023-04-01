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

    public TileManager(LogicGameState logicGameState){
        this.logicGameState = logicGameState;
        tiles = new Tile[10];
        loadTiles();
    }
    public void loadTiles() {
        tiles[0] = new Tile(false);
        tiles[1] = new Tile(true);
        tiles[2] = new Tile(true);
        tiles[3] = new Tile(true);
        tiles[4] = new Tile(true);
        tiles[5] = new Tile(true);
    }

}
