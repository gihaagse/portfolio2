import java.util.ArrayList;

public class Azc extends Plaats {
    private String adres;
    private ArrayList<Asielzoeker> asielzoekers;

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public ArrayList<Asielzoeker> getAsielzoekers() {
        return asielzoekers;
    }

    public void setAsielzoekers(Asielzoeker asielzoeker) {
        asielzoekers.add(asielzoeker);
    }

    void toevoegenAsielzoeker() {}

    void verwijderenAsielzoeker() {}
}