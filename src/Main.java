import Logic.LogicManager;
import Util.GameLoop;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        LogicManager logicManager = new LogicManager();
        GameLoop gameLoop = new GameLoop(logicManager,logicManager.gM);
        gameLoop.start();

    }
}
