package Graphic.Models.Object;

import Graphic.Models.GuiGameState;
import Graphic.Models.GuiPart;
import Logic.Models.Object.Coin;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class GuiCoinManager implements GuiPart {

    List<Coin> coinList;
    GuiGameState guiGameState;
    public int worldCols = 26 * 4;
    public int worldRows = 15;

    int[][] coinsColAndRow = new int[worldCols][worldRows];

    public GuiCoinManager(GuiGameState guiGameState) {

        this.guiGameState = guiGameState;
        loadCoinList();
    }

    public void loadCoinList() {


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
                        num = 1;
                    }
                    else {
                        num = 0;
                    }
                    coinsColAndRow[col][row] = num;
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

    @Override
    public void draw(Graphics2D g2) {

        int topLeftCol = guiGameState.gM.lM.logicGameState.background.topLeftColInWorld;
        int topLeftRow = 0;
//        System.out.println(topLeftCol);
        int col = topLeftCol;
        int row = topLeftRow;
        int x = 0;
        int y = 0;
//        System.out.println(col +" "+ row);

        while (col < worldCols && row < worldRows) {

            int isCoin = coinsColAndRow[col][row];

            if (isCoin == 1) {

                GuiCoin coin = new GuiCoin();
                g2.drawImage(coin.image, x, y+12, 32, 32, null);
            }
            col++;
            x += 48;

            if (col == worldCols) {

                col = topLeftCol;
                x = 0;
                row++;
                y += 48;
            }
        }
    }
}