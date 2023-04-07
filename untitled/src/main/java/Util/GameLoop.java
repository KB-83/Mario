package Util;

import Graphic.GraphicManager;
import Logic.LogicManager;

public class GameLoop implements Runnable{
    Thread gameThread;
    int FPS = 60;
    boolean running =false;
    int tryFps;

    //
    LogicManager lM;
    GraphicManager gM;

    public GameLoop(LogicManager lM, GraphicManager gM) {
        gM.guiGameState.setLoop(this);
        lM.userManager.logicGameState.setLoop(this);
        this.lM = lM;
        this.gM = gM;
    }

    public void start(){
        if(gameThread == null) {
        gameThread = new Thread(this);
        }
        running = true;
        gameThread.start();
    }

    public void stop(){
        running = false;
        gameThread = null;
    }
//    public void resume(){
//        running = true;
//    }

    public void run() {
        final long drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long startfPS = System.nanoTime();
        long delta = 0;
        long currentTime;
        System.out.println("check if running");
        while (running){
            currentTime = System.nanoTime();
            delta = (currentTime - lastTime) / drawInterval ;
            if(delta >= 1){
                tryFps++;
                lM.updateAll();
                gM.paintAll();
                lastTime = System.nanoTime();
                delta--;
            }
            if (System.nanoTime()-startfPS >= 1000000000){
                startfPS = System.nanoTime();
                tryFps = 0;
            }
        }
    }
}
