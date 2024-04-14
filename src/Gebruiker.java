import java.time.LocalDate;

public abstract class Gebruiker {
    private String naam;
    private String achternaam;
    private LocalDate geboortedatum;

    public Gebruiker(String naam, String achternaam, LocalDate geboortedatum){
        this.naam = naam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

}