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
    }

    public void run() {
        final long drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long startfPS = System.nanoTime();
        long delta = 0;
        long currentTime;
        while (gameThread != null){
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
