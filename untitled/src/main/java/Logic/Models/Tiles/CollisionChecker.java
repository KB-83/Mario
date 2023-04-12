package Logic.Models.Tiles;

import Graphic.Listeners.PlayerListener;
import Graphic.Models.Object.GuiCoin;
import Logic.Models.Entity.Player;
import Logic.Models.LogicGameState;
import Logic.Models.Object.CoinManager;
import Logic.Models.Object.PipeManager;

import java.io.FilterOutputStream;

public class CollisionChecker {
    public TileManager tileManager;
    public CoinManager coinManager;
    public PipeManager pipeManager;
    public Player player;
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
        if (player.worldX <  26 *48 * 4 - 60) {

            int playerLeftWorldX = player.worldX + player.solidArea.x;
            int playerRightWorldX = player.worldX + player.solidArea.x + player.solidArea.width;
            int playerTopWorldY = player.worldY + player.solidArea.y;
            int playerBottomWorldY = player.worldY + player.solidArea.y + player.solidArea.height;

            int playerLeftCol = playerLeftWorldX / 48;
            int playerRightCol = playerRightWorldX / 48;
            int playerTopRow = playerTopWorldY / 48;
            int playerBottomRow = playerBottomWorldY / 48;

//        System.out.print("player left col " +playerLeftCol);
//        System.out.print("player Right col " + playerRightCol);
//        System.out.print("player top row " + playerTopRow);
//        System.out.println("player BottomRow row " + playerBottomRow);

            int tileNum1, tileNum2;
            String action = playerListener.keyAndMode;

            switch (action) {
                case "WP":
                    playerTopRow = (playerTopWorldY - player.v) / 48;
                    tileNum1 = tileManager.logicGameState.guiGameState.background.mapTileNum[playerLeftCol][playerTopRow];
                    tileNum2 = tileManager.logicGameState.guiGameState.background.mapTileNum[playerRightCol][playerTopRow];
                    tile1 = tileManager.tiles[tileNum1];
                    tile2 = tileManager.tiles[tileNum2];
                    if (tile1.collision == true || tile2.collision == true) {
                        player.isCollisionOn = true;
                    }

                    break;
                case "DP":
                    playerRightCol = (playerRightWorldX + player.v) / 48;
                    tileNum1 = tileManager.logicGameState.guiGameState.background.mapTileNum[playerRightCol][playerTopRow];
                    tileNum2 = tileManager.logicGameState.guiGameState.background.mapTileNum[playerRightCol][playerBottomRow];
                    tile1 = tileManager.tiles[tileNum1];
                    tile2 = tileManager.tiles[tileNum2];
                    if (tile1.collision == true || tile2.collision == true) {
                        player.isCollisionOn = true;
                    }

                    break;
                case "AP":
                    playerLeftCol = (playerLeftWorldX - player.v) / 48;
                    tileNum1 = tileManager.logicGameState.guiGameState.background.mapTileNum[playerLeftCol][playerTopRow];
                    tileNum2 = tileManager.logicGameState.guiGameState.background.mapTileNum[playerLeftCol][playerBottomRow];
                    tile1 = tileManager.tiles[tileNum1];
                    tile2 = tileManager.tiles[tileNum2];
                    if (tile1.collision == true || tile2.collision == true) {
                        player.isCollisionOn = true;
                    }
                    break;
                case "SP":
                    playerBottomRow = (playerBottomWorldY + player.v) / 48;
                    tileNum1 = tileManager.logicGameState.guiGameState.background.mapTileNum[playerLeftCol][playerBottomRow];
                    tileNum2 = tileManager.logicGameState.guiGameState.background.mapTileNum[playerRightCol][playerBottomRow];
                    tile1 = tileManager.tiles[tileNum1];
                    tile2 = tileManager.tiles[tileNum2];
                    if (tile1.collision == true || tile2.collision == true) {
                        player.isCollisionOn = true;
                    }

            }
            checkIfCoin(tile1, tile2);

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
    public void jumpOverCollisionChecker(){
        int playerLeftCol = player.worldX/48;
        int playerTopRow = player.worldY/48;
        playerTopRow = (player.worldY + player.v)/48;
        tile1 = tileManager.tiles[tileManager.logicGameState.guiGameState.background.mapTileNum[playerLeftCol][playerTopRow+1]];
        tile2 = tileManager.tiles[tileManager.logicGameState.guiGameState.background.mapTileNum[playerLeftCol+1][playerTopRow +1]];
        if (tile1.collision || tile2.collision){
//            player.isBottomCollisionOn = true;
            checkIfCoin(tile1,tile2);
    }
    }
    private void checkIfCoin(Tile tile1,Tile tile2){
//        System.out.println("checking coin from collision checker");
        if (tile1 != null && tile2 != null) {
            System.out.println(tile1.num);
            if (this.tileManager.logicGameState.guiGameState.background.mapTileNum[player.worldX /48][player.worldY/48] == 7) {
                for (GuiCoin coin: this.tileManager.logicGameState.guiGameState.coinManager.coinList){
                    if (coin.worldCol == player.getWorldX()/48 && coin.worldRow == player.worldY/48) {
                        coin.isEaten = true;
                    }
                }
                this.tileManager.logicGameState.coins++;
                this.tileManager.logicGameState.guiGameState.background.mapTileNum[player.worldX /48][player.worldY/48] = 0;
//                tile1.num = 0;
//                tile2.num = 0;
            }
        }
    }

}
