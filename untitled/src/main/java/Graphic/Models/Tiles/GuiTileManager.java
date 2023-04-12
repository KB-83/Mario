package Graphic.Models.Tiles;

import Graphic.Models.Entity.GuiEnemy;
import Graphic.Models.GuiGameState;
import Graphic.Models.GuiPart;
import Graphic.Panels.GamePanel;
import Logic.Models.Entity.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GuiTileManager implements GuiPart {
    GuiGameState guiGameState;
    public GuiTile[] tiles;
    public int[][] mapTileNum;
    public GuiTileManager(GuiGameState guiGameState){

        this.guiGameState = guiGameState;
        tiles = new GuiTile[10];
        //going to change when world added
        mapTileNum = new int[worldCols][worldRows];
        loadTilesImage();
        loadMap();
        this.guiGameState.logicGameState.background.mapTileNum = this.mapTileNum;
    }

    public void loadMap(){

        try {
            int levelNum =  guiGameState.logicGameState.levelNum;
            int sectionNum = guiGameState.logicGameState.sectionNum;
            System.out.println("loadingMap"+sectionNum);

            InputStream is = getClass().getResourceAsStream("/Maps/map"+levelNum+sectionNum+".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < worldCols && row < worldRows){

                String line = br.readLine();

                while (col < worldCols) {

                    String numbers[] = line.split(" ");
                    int num;
                    // assuming coin and pipe background is sky;
                    if(numbers[col].equals("c")){
                        num = 7;
                    }
                    else if (numbers[col].equals("e")){
                        num = 0;

                    }
                    else if(numbers[col].equals("p") || numbers[col].equals("P")){
                        num = 6;
                        mapTileNum[col][row] = num;
                        mapTileNum[col + 1][row] = num;
                        mapTileNum[col][row -1] = num;
                        mapTileNum[col][row -1] = num;
                        if(numbers[col].equals("P")){
                            mapTileNum[col][row -2] = num;
                            mapTileNum[col][row -2] = num;
                        }
                    }
                    else {
                        num = Integer.parseInt(numbers[col]);
                    }
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col >= worldCols) {

                    col = 0;
                    row++;

                }
            }
            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadTilesImage() {

        try {

            tiles[0] = new GuiTile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Sky.png"));
            tiles[0].collision = false;

            tiles[1] = new GuiTile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile1.png"));

            tiles[2] = new GuiTile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile2.png"));

            tiles[3] = new GuiTile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile3.png"));

            tiles[4] = new GuiTile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile4.png"));

            tiles[5] = new GuiTile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile5.png"));

            // sky tile with pipe for collision
            tiles[6] = new GuiTile();
            tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Sky.png"));

            //for coin
            tiles[7] = new GuiTile();
            tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Sky.png"));
            tiles[7].collision = false;

        }catch (IOException e){

            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2){

        int topLeftCol = guiGameState.gM.lM.userManager.currentUser.currentGameState.background.topLeftColInWorld;
        int topLeftRow = 0;
        int col = topLeftCol;
        int row = topLeftRow;
        int x = 0;
        int y = 0;

        while (col < worldCols && row<  worldRows) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tiles[tileNum].image, x, y, tileSize,tileSize, null);
            col++;
            x += tileSize;

            if(col == worldCols){

                col = topLeftCol;
                x = 0;
                row++;
                y += tileSize;
            }
        }
    }
}
