package Logic.Models.Tiles;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Player;
import Logic.Models.LogicGameState;

import java.io.FilterOutputStream;

public class CollisionChecker {
    TileManager tileManager;
    Player player;
    PlayerListener playerListener;
    public int col , row;
    Tile up,right,down,left;

    public CollisionChecker(Player player) {

        this.tileManager = player.logicGameState.background;
        this.player = player;
        System.out.println(player);
        this.playerListener = player.playerListener;
    }

    public void checkCollision() {
//        System.out.println("here");

        player.isUpCollisionOn = false;
        player.isLeftCollisionOn = false;
        player.isBottomCollisionOn = false;
        player.isRightCollisionOn = false;


        int playerNewWorldX = player.worldX;
        int playerNewWorldY = player.worldY;
        String action = playerListener.keyAndMode;
//        System.out.println(playerListener.keyAndMode);
        switch (action) {
            case "WP":
                playerNewWorldY -= player.v;
                break;
            case "DP":
                playerNewWorldX += player.v;
                break;
            case "LP":
                playerNewWorldX -= player.v;
                break;
            case "SP":
                playerNewWorldY += player.v;
                break;
        }

        col = playerNewWorldX/ player.size;
        row = playerNewWorldY/ player.size;
//        System.out.println("player col "+ col +"player row " +row);
//        System.out.println(col +"   " +row);
            // at first its right

        // mark it as feature tile and the are same
        if(row >= 1 && col >= 0) {
                up = tileManager.tiles[tileManager.mapTileNum[col][row]];
            }
        if(row >= 0 && col >= 0) {
            right = tileManager.tiles[tileManager.mapTileNum[col+1][row+1]];
        }
        if(row >= 0 && col >= 0) {
            down = tileManager.tiles[tileManager.mapTileNum[col][row+1]];
        }
        if(row >= 0 && col >= 2) {
            left = tileManager.tiles[tileManager.mapTileNum[col-2][row+1]];
        }


        if (up != null && up.collision){
            player.isUpCollisionOn = true;
        }
        if (right != null && right.collision){
            player.isRightCollisionOn = true;
        }
        if (down != null && down.collision){
            player.isBottomCollisionOn = true;
        }
        if (left != null && left.collision){
            player.isLeftCollisionOn = true;
        }

    }
}
