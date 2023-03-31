package Util;

import Graphic.GraphicManager;
import Logic.LogicManager;

public class GameLoop implements Runnable{
    Thread gameThread;
    int FPS = 120;
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

    @Override
//    public void run() {
//        final long drawInterval = 1000000000/FPS;
//        long lastTime = System.nanoTime();
//        long delta = 0;
//        long currentTime;
//        while (gameThread != null){
//            currentTime = System.nanoTime();
//            delta = (currentTime - lastTime) / drawInterval ;
////            System.out.print("waiting:");
////            System.out.println(System.currentTimeMillis());
//            if(delta >= 1){
//                //do main
//                System.out.print("start lm update:");
//                System.out.println(System.currentTimeMillis());
//                lM.updateAll();
//                System.out.print("start gm update:");
//                System.out.println(System.currentTimeMillis());
//                gM.paintAll();
//                System.out.print("end gm:");
//                System.out.println(System.currentTimeMillis());
//
//                lastTime = System.nanoTime();
//                delta--;
//            }
//        }
//    }
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
//                System.out.println("fps"+tryFps);
                startfPS = System.nanoTime();
                tryFps = 0;
            }
        }
    }
}
