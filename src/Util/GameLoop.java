package Util;

import Graphic.GraphicManager;
import Logic.LogicManager;

public class GameLoop implements Runnable{
    Thread gameThread;
    int FPS = 60;
    boolean running =false;

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

    @Override
    public void run() {
        final long drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long delta = 0;
        long currentTime;
        while (running){
            currentTime = System.nanoTime();
            delta = (currentTime - lastTime) / drawInterval ;
            if(delta >= 1){
                //do main
                lM.updateAll();
                gM.paintAll();

                lastTime = System.nanoTime();
                delta--;
            }
        }
    }
}
