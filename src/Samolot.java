/**
 * Created by Torak28 on 20.12.2016.
 */
public class Samolot {
    private String nazwa;
    private int klasaOdleglosci;
    private int iloscMiejsc;
    private boolean stan;

    public String getNazwa(){
        return nazwa;
    }
    public void setNazwa(String N){
        nazwa = N;
    }
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
    public String getStan(){
        if(stan == true)
            return "sprawny";
        else
            return "niesprawny";
    }
    public boolean setStan(boolean S){
        stan = S;
        return true;
    }
    public Samolot(String NAZWA, int KO, int IM, boolean S){
        nazwa = NAZWA;
        klasaOdleglosci = KO;
        iloscMiejsc = IM;
        stan = S;
    }
}
