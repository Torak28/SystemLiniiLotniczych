/**
 * Created by Torak28 on 20.12.2016.
 */
public class Samolot {
    private String nazwa;
    private int klasaOdleglosci;
    private int iloscMiejsc;
    private boolean stan;
	private int numerLotu;

    public String getNazwa(){
        return nazwa;
    }
    public void setNazwa(String N){
        nazwa = N;
    }
    public int getKlasaOdleglosci(){
        return klasaOdleglosci;
    }
    public void setKlasaOdleglosci(int KO){
        klasaOdleglosci = KO;
    }
    public int getIloscMiejsc(){
        return iloscMiejsc;
    }
    public void setIloscMiejsc(int IM){
        iloscMiejsc = IM;
    }
    public String getStan(){
        if(stan == true)
            return "sprawny";
        else
            return "niesprawny";
    }
    public void setStan(boolean S){
        stan = S;
    }
    public int getNumerLotu(){
		return numerLotu;
	}
	public void setNumerLotu(int NL){
		numerLotu = NL;
	}
    public Samolot(String NAZWA, int KO, int IM, boolean S){
        nazwa = NAZWA;
        klasaOdleglosci = KO;
        iloscMiejsc = IM;
        stan = S;
		numerLotu = 0;
    }
    public boolean equals(Samolot o){
        if (o == null)
            return false;
        if (nazwa == o.getNazwa() && klasaOdleglosci == o.getKlasaOdleglosci() && iloscMiejsc == o.getIloscMiejsc() && numerLotu == o.getNumerLotu())
            return true;
        else
            return false;
    }
}
