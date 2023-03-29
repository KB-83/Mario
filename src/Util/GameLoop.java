package Util;

public class GameLoop implements Runnable{
    Thread gameThread;
    int FPS = 60;

//    public GameLoop(GamePanel gp){
//        this.gp = gp;
//    }
    public void setGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final long drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long delta = 0;
        long currentTime;
        while (gameThread != null){
            currentTime = System.nanoTime();
            delta = (currentTime - lastTime) / drawInterval ;
            if(delta >= 1){
                //
                lastTime = System.nanoTime();
                delta--;
            }
        }
    }
}
