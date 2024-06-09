import java.util.ArrayList;

public class Azc implements Observer {
    private String naam;
    private String adres;
    private ArrayList<Asielzoeker> asielzoekers;

    public Dossier dossier;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
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

    @Override
    public void setDossier(Dossier dossier){
        this.dossier = dossier;
    }

    @Override
    public void update(){
        System.out.println("Het dossier is geüpdate");
    }

    @Override
    public Dossier getDossier() {
        return dossier;
    }
}