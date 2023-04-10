package Graphic.Models.Object;

import Graphic.Models.Entity.GuiPlayer;
import Graphic.Models.GuiGameState;
import Graphic.Models.GuiPart;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GuiPipeManager implements GuiPart {

    GuiGameState guiGameState;
    List<GuiPipe> pipeList = new ArrayList<>();

    int[][] pipesColAndRow = new int[worldCols][worldRows];

    public GuiPipeManager(GuiGameState guiGameState){

        this.guiGameState = guiGameState;
        loadPipeList();
    }

    public void loadPipeList() {


        try {
            int levelNum =  guiGameState.logicGameState.levelNum;
            int sectionNum = guiGameState.logicGameState.sectionNum;
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
                    if(numbers[col].equals("p")){
                        num = 1;
                        GuiPipe guiPipe = new GuiPipe(false , col,row);
                        pipeList.add(guiPipe);;
                    }
                    else if(numbers[col].equals("P")){
                        num = 2;
                        GuiPipe guiPipe = new GuiPipe(true , col,row);
                        pipeList.add(guiPipe);;
                    }
                    else {
                        num = 0;
                    }
                    pipesColAndRow[col][row] = num;
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
        for (GuiPipe guiPipe:pipeList){
            if(guiPipe.worldCol >= topLeftCol) {
                screenCol = guiPipe.worldCol - topLeftCol;
                if (guiPipe.isBiggerOne){
                screenRow = guiPipe.worldRow - 2 ;
                }
                else {
                    screenRow = guiPipe.worldRow - 1;
                }

                g2.drawImage(guiPipe.image , screenCol *tileSize , screenRow * tileSize,null);
            }
        }
    }

}
