import java.util.ArrayList;
import java.util.List;

/**
 * Created by Torak28 on 20.12.2016.
 */
public class Lot {
    private List<Bilet> Bilety = new ArrayList<Bilet>();
    Samolot samolot;
    private int numerLotu;
    private int iloscKupionych;
    private int iloscZarezerwowanych;

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
    public boolean dodajBiletKupiony(){
        Bilet dodawanyBilet = new Bilet(numerLotu, 1, numerLotu/10, numerLotu%10, 10, 10);
        if(Bilety.add(dodawanyBilet)){
            return true;
        }
        return false;
    }
    public boolean dodajBiletZarezerwowany(){
        return true;
    }
    public boolean usunBiletKupiony(){
        return true;
    }
    public boolean usunBiletZarezerwowany(){
        return true;
    }
    public Samolot getSamolot(){
        return samolot;
    }
    public boolean setSamolot(Samolot S){
        samolot = S;
        return true;
    }
    public String wygrnerujRaport(){
        return "Raport";
    }
    public boolean szukajBiletu(int NL){
        int iloscBiletow = Bilety.size();
        for (int i = 0; i < iloscBiletow; i++) {
            if (Bilety.get(i).getNumerLotu() == NL) {
                return true;
            }
        }
        return false;
    }
    public Lot(int NL, int IK, int IZ, Samolot S){
        numerLotu = NL;
        iloscZarezerwowanych = IZ;
        iloscKupionych = IK;
        samolot = S;
    }
}
