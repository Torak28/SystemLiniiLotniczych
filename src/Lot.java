import java.util.ArrayList;
import java.util.List;

/**
 * Created by Torak28 on 20.12.2016.
 */
public class Lot {
    private List<Bilet> Bilety = new ArrayList<Bilet>();
    Samolot samolot;
    private int numerLotu;
    private int iloscKupionych = 0;
    private int iloscZarezerwowanych = 0;
    private int miastoPoczatkowe;
    private int miastoKoncowe;
    private int data;
    private int godzina;

    public int getNumerLotu(){
        return numerLotu;
    }
    public boolean setNumerLotu(int NL){
        numerLotu = NL;
        return true;
    }
    public int getIloscKupionych(){
        return iloscKupionych;
    }
    public boolean setIloscKupionych(int IK){
        iloscKupionych = IK;
        return true;
    }
    public int getIloscZarezerwowanych(){
        return iloscZarezerwowanych;
    }
    public boolean setIloscZarezerwowanych(int IZ){
        iloscZarezerwowanych = IZ;
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
    public boolean dodajBiletKupiony(int nl, int typ, int mp, int mk, int d, int g){
        if(iloscZarezerwowanych + iloscKupionych < samolot.getIloscMiejsc())
        {
            Bilet bilet = new Bilet(nl,typ,mp,mk,d,g);
            Bilety.add(bilet);
            System.out.println("Bilet kupionoy zostal dodany do tego lotu.\n");
            iloscKupionych++;
            return true;
        }
        else {
            System.out.println("Brak miejsc w samolocie.\n");
            return false;
        }
    }
    public boolean dodajBiletZarezerwowany(int nl, int typ, int mp, int mk, int d, int g){
        if(iloscZarezerwowanych + iloscKupionych < samolot.getIloscMiejsc())
        {
            Bilet bilet = new Bilet(nl,typ,mp,mk,d,g);
            Bilety.add(bilet);
            System.out.println("Bilet zarezerwowany zostal dodany do tego lotu.\n");
            iloscZarezerwowanych++;
            return true;
        }
        else {
            System.out.println("Brak miejsc w samolocie.\n");
            return false;
        }
    }
    //Nie usuwam z listy biletow
    public boolean usunBiletKupiony(){
        if(iloscKupionych != 0)
            iloscKupionych--;
        else System.out.println("Brak biletow kupionych");
        return true;
    }
	//Nie usuwam z listy biletow
    public boolean usunBiletZarezerwowany(){
        if(iloscZarezerwowanych != 0)
            iloscZarezerwowanych--;
        else System.out.println("Brak biletow zarezerwowanych");
        return true;
    }
    public Samolot getSamolot(){
        return samolot;
    }
    public boolean setSamolot(Samolot S){
        samolot = S;
        return true;
    }
    // xd
    public String wygenerujRaport(){
        return "Raport";
    }
    // zmienic dane
    public boolean szukajBiletu(int NL){
        return true;
    }
    public Lot(int NL, int IK, int IZ, Samolot S){
        numerLotu = NL;
        iloscZarezerwowanych = IZ;
        iloscKupionych = IK;
        samolot = S;
    }
}
