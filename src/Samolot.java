/**
 * Created by Torak28 on 20.12.2016.
 */
public class Samolot {
    private int klasaOdleglosci;
    private int iloscMiejsc;
    private boolean stan;

    public int getKlasaOdleglosci(){
        return klasaOdleglosci;
    }
    public boolean setKlasaOdleglosci(int KO){
        klasaOdleglosci = KO;
        return true;
    }
    public int getIloscMiejsc(){
        return iloscMiejsc;
    }
    public boolean setIloscMiejsc(int IM){
        iloscMiejsc = IM;
        return true;
    }
    public boolean getStan(){
        return stan;
    }
    public boolean setStan(boolean S){
        stan = S;
        return true;
    }
    public Samolot(int KO, int IM, boolean S){
        klasaOdleglosci = KO;
        iloscMiejsc = IM;
        stan = S;
    }
}
