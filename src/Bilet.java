/**
 * Created by Torak28 on 20.12.2016.
 */
public class Bilet {
    private int numerLotu;
    private int typ; //1 - kupiony 0 - zaarezerwowany
    private int miastoPoczatkowe;
    private int miastoKoncowe;
    private int data;
    private int godzina;
    private int miejsce;


    public int getMiejsce(){
        return miejsce;
    }
    public void setMiejsce(int M){
        miejsce = M;
    }
    public int getNumerLotu(){
        return numerLotu;
    }
    public int getTyp(){
        return typ;
    }
    public boolean setTyp(int T){
        typ = T;
        return true;
    }
    public int getMiastoPoczatkowe(){
        return miastoPoczatkowe;
    }
    public boolean setMiastoPoczatkowe(int MP){
        miastoPoczatkowe = MP;
        return true;
    }
    public int getMiastoKoncowe(){
        return miastoKoncowe;
    }
    public boolean setMiastoKoncowe(int MK){
        miastoKoncowe = MK;
        return true;
    }
    public int getData(){
        return data;
    }
    public boolean setData(int D){
        data = D;
        return true;
    }
    public int getGodzina(){
        return godzina;
    }
    public boolean setGodzina(int G){
        godzina = G;
        return true;
    }
    public Bilet(int NL, int T, int MP, int MK, int D, int G){
        numerLotu = NL;
        typ = T;
        miastoKoncowe = MK;
        miastoPoczatkowe = MP;
        data = D;
        godzina = G;
    }
}

