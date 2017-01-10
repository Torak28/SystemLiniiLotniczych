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
    private int miastoPoczatkowe;
    private int miastoKoncowe;
    private int data;
    private int godzina;

    public int getNumerLotu(){
        return numerLotu;
    }
    public void setNumerLotu(int NL){
        numerLotu = NL;
    }
    public int getIloscKupionych(){
        return iloscKupionych;
    }
    public void setIloscKupionych(int IK){
        iloscKupionych = IK;
    }
    public int getIloscZarezerwowanych(){
        return iloscZarezerwowanych;
    }
    public void setIloscZarezerwowanych(int IZ){
        iloscZarezerwowanych = IZ;
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
    public boolean dodajBiletKupiony(int mp, int mk, int d, int g){
        if(iloscZarezerwowanych + iloscKupionych < samolot.getIloscMiejsc())
        {
            Bilet bilet = new Bilet(generujNumerLotu(),1,mp,mk,d,g,Bilety.size()+1);
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
    public boolean dodajBiletZarezerwowany(int mp, int mk, int d, int g){
        if(iloscZarezerwowanych + iloscKupionych < samolot.getIloscMiejsc())
        {
            Bilet bilet = new Bilet(generujNumerLotu(),0,mp,mk,d,g,Bilety.size()+1);
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
    public boolean setSamolot(Samolot S) {
		samolot = S;
		return true;
	}
    public String wygenerujRaport(){
		String out;
		out = "Lot numer " + numerLotu +":\n\tMiasto początkowe: " + miastoPoczatkowe + "\n\tMiasto końcowe: " + miastoKoncowe + "\n\tData: " + data + "\n\tGodzina: " + godzina;
		out += "\n\tIlość Biletów: " + (iloscKupionych + iloscZarezerwowanych) + "\n\t\tKupione: " + iloscKupionych + "\n\t\tZarezerwowane: " + iloscZarezerwowanych;
        return out;
    }
    // zmienic dane
    public boolean szukajBiletu(int NL){
        return true;
    }
	public int generujNumerLotu(){
		return  miastoPoczatkowe + miastoKoncowe + data + godzina;
	}
    public Lot(int MP, int MK, int D, int G,Samolot S){
        numerLotu = generujNumerLotu();
		miastoPoczatkowe = MP;
		miastoKoncowe = MK;
		data = D;
		godzina = G;
        iloscZarezerwowanych = 0;
        iloscKupionych = 0;
        samolot = S;
    }
}
