package Logic.Models.Tiles;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Player;
import Logic.Models.LogicGameState;
import Logic.Models.Object.CoinManager;
import Logic.Models.Object.PipeManager;

import java.io.FilterOutputStream;

public class CollisionChecker {
    public TileManager tileManager;
    public CoinManager coinManager;
    public PipeManager pipeManager;
    Player player;
    PlayerListener playerListener;
    Tile tile1,tile2;

    public CollisionChecker(Player player) {

//        this.tileManager = player.currentUser.currentGameState.background;
        this.player = player;
//        System.out.println(player);
        this.playerListener = player.playerListener;
    }

    public CollisionChecker() {
    }

    public void checkCollision() {
//        System.out.println("here");

        player.isUpCollisionOn = false;
        player.isLeftCollisionOn = false;
        player.isBottomCollisionOn = false;
        player.isRightCollisionOn = false;


        int playerLeftCol = player.worldX/48;
        int playerTopRow = player.worldY/48;
//        System.out.println(player.worldY/48.0);
        String action = playerListener.keyAndMode;
//        System.out.println(playerLeftCol);
//        System.out.println(playerTopRow);
//        System.out.println(playerListener.keyAndMode);
        switch (action) {
            case "WP":
//                playerTopRow = (player.worldY- player.v)/48;
                tile1 = tileManager.tiles[tileManager.mapTileNum[playerLeftCol][playerTopRow]];
                tile2 = tileManager.tiles[tileManager.mapTileNum[playerLeftCol+1][playerTopRow]];
                if (tile1.collision || tile2.collision){
                    player.isUpCollisionOn = true;
                }
                break;
            case "DP":
//                playerLeftCol = (player.worldX + player.v)/48;
                if(playerLeftCol <= 26 * 4 - 2) {
                    tile1 = tileManager.tiles[tileManager.mapTileNum[playerLeftCol + 1][playerTopRow]];
                    tile2 = tileManager.tiles[tileManager.mapTileNum[playerLeftCol + 1][playerTopRow + 1]];
                    System.out.println(player.worldY / 48.0 % 48 - playerTopRow);
                }
//                if(Math.abs(player.worldY/48.0 % 48 - playerTopRow ) < 1){
//                    System.out.println("collision");
//                    tile2 = tile1;
//                }
                if (tile1.collision || tile2.collision){
                    player.isRightCollisionOn = true;
                }
                break;
            case "AP":
//                playerLeftCol = (player.worldX- player.v)/48;
                tile1 = tileManager.tiles[tileManager.mapTileNum[playerLeftCol ][playerTopRow]];
                tile2 = tileManager.tiles[tileManager.mapTileNum[playerLeftCol ][playerTopRow + 1]];
                if(player.worldY% 48 == 0){
                    tile2 = tile1;
                }
                if (tile1.collision || tile2.collision){
                    player.isLeftCollisionOn = true;
                }
                break;
            case "SP":
//                playerTopRow = (player.worldY + player.v)/48;
                tile1 = tileManager.tiles[tileManager.mapTileNum[playerLeftCol][playerTopRow+1]];
                tile2 = tileManager.tiles[tileManager.mapTileNum[playerLeftCol+1][playerTopRow +1]];
                if (tile1.collision || tile2.collision){
                    player.isBottomCollisionOn = true;
                }
                break;
        }

//        col = playerNewWorldX/ player.size;
//        row = playerNewWorldY/ player.size;
////        System.out.println("player col "+ col +"player row " +row);
////        System.out.println(col +"   " +row);
//            // at first its right
//
//        // mark it as feature tile and the are same
//        if(row >= 1 && col >= 0) {
//
//                num1 = tileManager.tiles[tileManager.mapTileNum[col][row]];
//            }
//        if(row >= 0 && col >= 0) {
//            right = tileManager.tiles[tileManager.mapTileNum[col+1][row+1]];
//        }
//        if(row >= 0 && col >= 0) {
//            down = tileManager.tiles[tileManager.mapTileNum[col][row+1]];
//        }
//        if(row >= 0 && col >= 2) {
//            left = tileManager.tiles[tileManager.mapTileNum[col-2][row+1]];
//        }
//
//
//        if (up != null && up.collision){
//            player.isUpCollisionOn = true;
//        }
//        if (right != null && right.collision){
//            player.isRightCollisionOn = true;
//        }
//        if (down != null && down.collision){
//            player.isBottomCollisionOn = true;
//        }
//        if (left != null && left.collision){
//            player.isLeftCollisionOn = true;
//        }

    }
}
