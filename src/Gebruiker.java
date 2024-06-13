import java.time.LocalDate;
import java.util.Scanner;

public abstract class Gebruiker {
    private String naam;
    private String achternaam;
    private Gender gender;
    private LocalDate geboortedatum;
    Scanner scanner = new Scanner (System.in);


    public Gebruiker(String naam, String achternaam, LocalDate geboortedatum){
        this.naam = naam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;

    }

    public Gebruiker(){}

    public void actieUitvoeren(){}
    public String vraagVoornaam() {
        System.out.println("Wat is de voornaam?");
        System.out.println("voornaam: ");
        return scanner.nextLine();
    }

    public String vraagAchternaam() {
        System.out.println();
        System.out.println("Wat is de achternaam?");
        System.out.println("Achternaam: ");
        return scanner.nextLine();
    }

    public int vraagGeboorteJaar() {
        System.out.println();
        System.out.println("Wat is het geboortejaar?");
        System.out.println("Geboortejaar: ");
        return KeuzeChecker.keuzeInRange(1900, LocalDate.now().getYear());

    }

    public Gender vraagGender(){
        System.out.println();
        System.out.println("Wat is de gender?");
        System.out.println("1) Man");
        System.out.println("2) Vrouw");
        System.out.println("3) Geen gender");
        int keuze = KeuzeChecker.keuzeCheck(3);

        switch (keuze){

            case 1: return Gender.MAN;
            case 2: return Gender.VROUW;
            case 3: return Gender.GEEN;
            default:
                System.out.println("Gender is onbekend");
                return Gender.GEEN;

        }
    }

    public int vraagGeboorteMaand() {
        System.out.println();
        System.out.println("Wat is de geboortemaand? (in cijfers)");
        System.out.println("GeboorteMaand: ");
        return KeuzeChecker.keuzeInRange(1, 12); }

    public int vraagGeboorteDag(){

        System.out.println();
        System.out.println("Wat is de geboortedag?");
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

    public Gender getGender(){
        return gender;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    void opvragenStatusDossier(){};

    Archief getArchief(){
        return null;
    }

}