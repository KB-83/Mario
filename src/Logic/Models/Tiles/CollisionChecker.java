package Logic.Models.Tiles;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Player;
import Logic.Models.LogicGameState;

import java.io.FilterOutputStream;

public class CollisionChecker {
    TileManager tileManager;
    Player player;
    PlayerListener playerListener;
    int col , row;
    Tile up,right,down,left;

    public CollisionChecker(Player player) {

        this.tileManager = player.logicGameState.background;
        this.player = player;
        System.out.println(player);
        this.playerListener = player.playerListener;
    }

    public void checkCollision() {
//        System.out.println("here");

//        player.isUpCollisionOn = false;
//        player.isLeftCollisionOn = false;
//        player.isBottomCollisionOn = false;
//        player.isRightCollisionOn = false;


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

        col = (playerNewWorldX + player.leftCollisionLeDistanceFromX) / player.size;
        row = (playerNewWorldY + player.topCollisionLeDistanceFromY) / player.size;
//        System.out.println(col +"   " +row);
        if (col >= 0 && row >= 0) {
            // at first its right
            up = tileManager.tiles[tileManager.mapTileNum[col][row]];
            right = tileManager.tiles[tileManager.mapTileNum[col][row + 1]];
            down = tileManager.tiles[tileManager.mapTileNum[col + 1][row]];
            left = tileManager.tiles[tileManager.mapTileNum[col][row]];
        }


        if (up.collision){
            player.isUpCollisionOn = true;
        }
        if (right.collision){
            player.isRightCollisionOn = true;
        }
        if (down.collision){
            player.isBottomCollisionOn = true;
        }
        if (left.collision){
            player.isLeftCollisionOn = true;
        }

    }
}
