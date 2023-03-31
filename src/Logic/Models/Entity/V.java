package Logic.Models.Entity;

public enum V {

    Mario(4);

    int v;

    V(int v ){
        this.v = v;
    }

    public int returnV(){
        return v;
    }
}
