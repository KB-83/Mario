package Util;

import Graphic.GraphicManager;
import Logic.LogicManager;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class GameLoop implements Runnable{
    @JsonIgnore
    Thread gameThread;
    int FPS = 60;
    boolean running =false;
    int tryFps;

    //
    @JsonIgnore
    LogicManager lM;
    @JsonIgnore
    GraphicManager gM;
    public  GameLoop(){}

    public GameLoop(LogicManager lM, GraphicManager gM) {
//        gM.guiUserManager.guiGameState.setLoop(this);
        lM.userManager.currentUser.currentGameState.setLoop(this);
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

    public Thread getGameThread() {
        return gameThread;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

    public int getFPS() {
        return FPS;
    }

    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTryFps() {
        return tryFps;
    }

    public void setTryFps(int tryFps) {
        this.tryFps = tryFps;
    }

    public LogicManager getlM() {
        return lM;
    }

    public void setlM(LogicManager lM) {
        this.lM = lM;
    }

    public GraphicManager getgM() {
        return gM;
    }

    public void setgM(GraphicManager gM) {
        this.gM = gM;
    }
}
