import java.time.LocalDate;
import java.util.Scanner;

public abstract class Gebruiker {
    private String naam;
    private String achternaam;
    private LocalDate geboortedatum;
    Scanner scanner = new Scanner (System.in);


    public Gebruiker(String naam, String achternaam, LocalDate geboortedatum){
        this.naam = naam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;

    }

    public Gebruiker(){}
    public String vraagVoornaam() {
        System.out.println("Wat is uw voornaam?");
        System.out.println("voornaam: ");
        return scanner.nextLine();
    }

    public String vraagAchternaam() {
        System.out.println();
        System.out.println("Wat is uw achternaam?");
        System.out.println("Achternaam: ");
        return scanner.nextLine();
    }

    public int vraagGeboorteJaar() {
        System.out.println();
        System.out.println("Wat is uw geboortejaar?");
        System.out.println("Geboortejaar: ");
        return KeuzeChecker.keuzeInRange(1900, LocalDate.now().getYear());

    }

    public int vraagGeboorteMaand() {
        System.out.println();
        System.out.println("Wat is uw geboortemaand? (in cijfers)");
        System.out.println("GeboorteMaand: ");
        return KeuzeChecker.keuzeInRange(1, 12); }

    public int vraagGeboorteDag(){

        System.out.println();
        System.out.println("Wat is uw geboortedag?");
        System.out.println("Geboortedag: ");
        return KeuzeChecker.keuzeInRange(1,31);

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