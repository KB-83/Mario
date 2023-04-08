package Logic.Models.Entity;

public enum V {

    Mario(18),
    UniqueGirl(5),
    Luigi(3),
    Princess(7),
    Poker(17);

//    UniqueGirl(5);

    int v;

    V(int v ){
        this.v = v;
    }

    public int returnV(){
        return v;
    }
}
