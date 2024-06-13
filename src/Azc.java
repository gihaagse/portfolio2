import java.util.ArrayList;

public class Azc implements Observer {
    private String naam;
    private Woonplaats adres;
    private ArrayList<Asielzoeker> asielzoekers;

    public Archief archief;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Woonplaats getAdres() {
        return adres;
    }

public void setAdres(Woonplaats adres) {
        this.adres = adres;
    }

    public ArrayList<Asielzoeker> getAsielzoekers() {
        return asielzoekers;
    }

    public void setAsielzoekers(Asielzoeker asielzoeker) {
        asielzoekers.add(asielzoeker);
    }

    void toevoegenAsielzoeker() {
    }

    void verwijderenAsielzoeker() {
    }


    @Override
    public void setArchief(Archief archief) {
        this.archief = archief;
    }

    @Override
    public void updateWoningOpgestart(Gebruiker asielzoeker) {
        System.out.println("UPDATE MELDING (AZC): ");
        System.out.println("De plaatsing in een eigen woning van " + asielzoeker.getNaam() + " " + asielzoeker.getAchternaam() + " is opgestart." );
    }

    @Override
    public void updateWoningAfgerond(Gebruiker asielzoeker) {
        System.out.println("UPDATE MELDING (AZC): ");
        System.out.println("De plaatsing in een eigen woning van " + asielzoeker.getNaam() + " " + asielzoeker.getAchternaam() + " is afgerond.");

    }
    @Override
    public Archief getArchief() {
        return archief;
    }

}