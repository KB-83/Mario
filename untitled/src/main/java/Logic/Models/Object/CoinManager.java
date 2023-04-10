package Logic.Models.Object;

import Graphic.Models.Object.GuiCoin;
import Logic.LogicPart;
import Logic.Models.LogicGameState;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class CoinManager implements LogicPart {
    @JsonIgnore
    LogicGameState logicGameState;
    int[][] coinsColAndRow = new int[worldCols][worldRows];
    List<Coin> coinList = new ArrayList<>();
    public CoinManager(){}
    public CoinManager(LogicGameState logicGameState){
        this.logicGameState = logicGameState;
    }

    public void setCoinsColAndRow(int[][] coinsColAndRow) {
        this.coinsColAndRow = coinsColAndRow;
    }
    public void createCoinList() {
        for (int i = 0;i<worldCols;i++){
            for (int j = 0;j<worldRows;j++){
                if(coinsColAndRow[i][j] == 1){
                    Coin coin = new Coin(i,j);
                    coinList.add(coin);
                }
            }
        }
    }

    public LogicGameState getLogicGameState() {
        return logicGameState;
    }

    public void setLogicGameState(LogicGameState logicGameState) {
        this.logicGameState = logicGameState;
    }

    public int[][] getCoinsColAndRow() {
        return coinsColAndRow;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
