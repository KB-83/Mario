package Graphic.Models.Tiles;

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
    int[][] mapTileNum;

    public int screenCols = 26;
    public int screenRows = 15;
    public int worldCols = 26 * 4;
    public int worldRows = 15;
    public int tileSize = 48;

    public GuiTileManager(GuiGameState guiGameState){

        this.guiGameState = guiGameState;
        tiles = new GuiTile[10];
        //going to change when world added
        mapTileNum = new int[worldCols][worldRows];
        loadTilesImage();
        loadMap();
    }

    public void loadMap(){

        try {

            InputStream is = getClass().getResourceAsStream("/Maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < worldCols && row < worldRows){

                String line = br.readLine();

                while (col < worldCols) {

                    String numbers[] = line.split(" ");
                    int num;
                    // assuming coin background is sky;
                    if(numbers[col].equals("c")){
                        num = 0;
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
//        this.guiGameState.gM.lM.logicGameState.background.mapTileNum = this.mapTileNum;
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

        }catch (IOException e){

            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2){

        int topLeftCol = guiGameState.gM.lM.logicGameState.background.topLeftColInWorld;
        int topLeftRow = 0;
//        System.out.println(topLeftCol);
        int col = topLeftCol;
        int row = topLeftRow;
        int x = 0;
        int y = 0;
//        System.out.println(col +" "+ row);

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
