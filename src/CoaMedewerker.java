import java.time.LocalDate;
import java.util.Scanner;

public class CoaMedewerker extends Gebruiker {
    private boolean coaMedewerker;

    public CoaMedewerker(String naam, String achternaam, LocalDate geboortedatum, boolean coaMedewerker) {
        super(naam, achternaam, geboortedatum);
        this.coaMedewerker = coaMedewerker;

    }

    public CoaMedewerker() {
    }

    public boolean isCoaMedewerker() {
        return coaMedewerker;
    }

    public void setCoaMedewerker(boolean coaMedewerker) {
        this.coaMedewerker = coaMedewerker;
    }

    public void actieUitvoeren() {

        System.out.println("Wat voor actie wilt u uitvoeren?");

        System.out.println("(Voorlopig alleen deze optie)");
        System.out.println("1) Vluchteling registreren");

        int keuze = KeuzeChecker.keuzeCheck(1);

        switch (keuze) {
            case 1:
                registrerenVluchteling();
                break;
            default:
                System.out.println("Deze keuze is er niet");;
                break;
        }


    }




    public void registrerenVluchteling() {
        System.out.println("U heeft gekozen voor het registreren van een vluchteling.");
        System.out.println("Wat is de voornaam van de vluchteling die u wilt registreren?");
    }

    void opvragenGemeente() {}

    void bijwerkenDossier() {}
}
