package Graphic.Models.Entity;

import Graphic.Models.GuiGameState;
import Graphic.Models.GuiPart;
import Graphic.Models.Object.GuiPipe;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class GuiPlantManager implements GuiPart {
    GuiGameState guiGameState;
    List<GuiEnemy> plantList;
    Timer timer;

    int[][] plantsColAndRow = new int[worldCols][worldRows];

    public GuiPlantManager(GuiGameState guiGameState){

        this.guiGameState = guiGameState;
        loadPlantList();
    }

    public void loadPlantList() {

        plantList = new ArrayList<>();
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
                    if(numbers[col].equals("e")){
                        num = 1;
                        GuiEnemy guiPlant = new GuiEnemy( col * 48,row * 48,1);
                        guiPlant.timer.start();
                        plantList.add(guiPlant);
                    }
                    else if(numbers[col].equals("E")){
                        GuiEnemy guiPlant = new GuiEnemy( col * 48,row * 48,2);
                        guiPlant.timer.start();
                        plantList.add(guiPlant);
                        num = 1;
                    }
                    else {
                        num = 0;
                    }
                    plantsColAndRow[col][row] = num;
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
        for (GuiEnemy guiPlant:plantList){
            if(guiPlant.worldX/48 >= topLeftCol && guiPlant.imageNumber ==1) {
                int screenX = guiPlant.worldX - topLeftCol * 48;
                g2.drawImage(guiPlant.image , screenX, guiPlant.worldY,tileSize,tileSize,null);
            }
            else if(guiPlant.worldX/48 >= topLeftCol && guiPlant.imageNumber ==2) {
                int screenX = guiPlant.worldX - topLeftCol * 48;
                g2.drawImage(guiPlant.image , screenX, guiPlant.worldY,null);
            }
        }
    }
}
