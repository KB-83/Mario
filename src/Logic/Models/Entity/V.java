package Logic.Models.Entity;

public enum V {

    Mario(8);

    int v;

    V(int v ){
        this.v = v;
    }

    public int returnV(){
        return v;
    }
}
