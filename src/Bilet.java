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
    public void setTyp(int T){
        typ = T;
    }
    public int getMiastoPoczatkowe(){
        return miastoPoczatkowe;
    }
    public void setMiastoPoczatkowe(int MP){
        miastoPoczatkowe = MP;
    }
    public int getMiastoKoncowe(){
        return miastoKoncowe;
    }
    public void setMiastoKoncowe(int MK){
        miastoKoncowe = MK;
    }
    public int getData(){
        return data;
    }
    public void setData(int D){
        data = D;
    }
    public int getGodzina(){
        return godzina;
    }
    public void setGodzina(int G){
        godzina = G;
    }
    public Bilet(int NL, int T, int MP, int MK, int D, int G, int M){
        numerLotu = NL;
        typ = T;
        miastoKoncowe = MK;
        miastoPoczatkowe = MP;
        data = D;
        godzina = G;
		miejsce = M;
    }
}

