import java.time.LocalDate;
import java.util.Scanner;

public abstract class Gebruiker {
    private String naam;
    private String achternaam;
    private LocalDate geboortedatum;


    public Gebruiker(String naam, String achternaam, LocalDate geboortedatum){
        this.naam = naam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;

    }
    public void maakGebruiker(){
        Scanner scanner = new Scanner (System.in);

        System.out.println("Wat is uw voornaam?");
        System.out.println("voornaam: ");
        String voornaam = scanner.nextLine();

        System.out.println();
        System.out.println("Wat is uw achternaam?");
        System.out.println("Achternaam: ");
        String achternaam = scanner.nextLine();

        System.out.println();
        System.out.println("Wat is uw geboortejaar?");
        System.out.println("Geboortejaar: ");
        int geboorteJaar = scanner.nextInt();

        System.out.println();
        System.out.println("Wat is uw geboortemaand? (in cijfers)");
        System.out.println("GeboorteMaand: ");
        int geboorteMaand = scanner.nextInt();

        System.out.println();
        System.out.println("Wat is uw geboortedag?");
        System.out.println("Geboortedag: ");
        int geboorteDag = scanner.nextInt();

        return(voornaam, achternaam, geboorteJaar, geboorteMaand, geboorteDag);
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