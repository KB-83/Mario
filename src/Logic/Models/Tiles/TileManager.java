package Logic.Models.Tiles;

import Graphic.Panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tiles;
    int[][] mapTileNum;

    public TileManager(GamePanel gamePanel){

        this.gamePanel = gamePanel;
        tiles = new Tile[10];
        //going to change when world added
        mapTileNum = new int[gamePanel.cardPanel.cols][gamePanel.cardPanel.rows];
        loadTilesImage();
        loadMap();
    }

    public void loadMap(){

        try {

            InputStream is = getClass().getResourceAsStream("/Maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gamePanel.cardPanel.cols && row < gamePanel.cardPanel.rows){

                String line = br.readLine();

                while (col < gamePanel.cardPanel.cols) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gamePanel.cardPanel.cols) {

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

            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Sky.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile1.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile2.png"));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile3.png"));

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile4.png"));

            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/Images/Tiles/Tile5.png"));

        }catch (IOException e){

            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gamePanel.cardPanel.cols && row< gamePanel.cardPanel.rows) {

            int tilenum = mapTileNum[col][row];

            g2.drawImage(tiles[tilenum].image, x, y, gamePanel.cardPanel.tileSize, gamePanel.cardPanel.tileSize, null);
            col++;
            x += gamePanel.cardPanel.tileSize;

            if(col == gamePanel.cardPanel.tileSize){
                col = 0;
                x = 0;
                row++;
                y += gamePanel.cardPanel.tileSize;
            }
        }
    }


}
