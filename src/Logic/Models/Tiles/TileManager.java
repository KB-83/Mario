package Logic.Models.Tiles;

import Graphic.Models.GuiGameState;
import Graphic.Models.Tiles.GuiTile;
import Logic.Models.LogicGameState;

public class TileManager {

    public int screenCols = 26;
    public int screenRows = 15;
    public int worldCols = 26 * 4;
    public int worldRows = 15;
    LogicGameState logicGameState;
    Tile[] tiles;

    public TileManager(LogicGameState logicGameState){
        this.logicGameState = logicGameState;
    }

    public void loadTiles() {
        GuiTile[] guiTiles = this.logicGameState.lM.gM.guiGameState.background.tiles;
        for (int i = 0; i<guiTiles.length; i++){
            Tile tile = new Tile(guiTiles[i].collision);
            this.tiles[i] = tile;
        }
    }

}
