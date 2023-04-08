package Graphic.Models.Object;

import Graphic.Models.GuiGameState;
import Graphic.Models.GuiPart;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GuiCoinManager implements GuiPart {

    List<GuiCoin> coinList = new ArrayList<>();
    GuiGameState guiGameState;

    int[][] coinsColAndRow = new int[worldCols][worldRows];

    public GuiCoinManager(GuiGameState guiGameState) {

        this.guiGameState = guiGameState;
        loadCoinList();
    }

    public void loadCoinList() {


        try {

            int levelNum =  guiGameState.gM.lM.userManager.currentUser.currentGameState.levelNum;
            int sectionNum = guiGameState.gM.lM.userManager.currentUser.currentGameState.sectionNum;
            InputStream is = getClass().getResourceAsStream("/Maps/map"+levelNum+sectionNum+".txt");
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
                        GuiCoin guiCoin = new GuiCoin(col,row);
                        coinList.add(guiCoin);
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
    }

    @Override
    public void draw(Graphics2D g2) {

        int topLeftCol = guiGameState.gM.lM.userManager.currentUser.currentGameState.background.topLeftColInWorld;
        int screenCol ;
        int screenRow ;
            for (GuiCoin guiCoin:coinList){
                if(guiCoin.worldCol >= topLeftCol) {
                    screenCol = guiCoin.worldCol - topLeftCol;
                    screenRow = guiCoin.worldRow;
                    g2.drawImage(guiCoin.image , screenCol *tileSize , screenRow * tileSize + 20,24,24,null);
                }
            }
        }
}