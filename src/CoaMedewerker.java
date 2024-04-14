import java.time.LocalDate;
import java.util.Scanner;

public class CoaMedewerker extends Gebruiker {
    private boolean coaMedewerker;

    public CoaMedewerker(String naam, String achternaam, LocalDate geboortedatum, boolean coaMedewerker){
        super(naam, achternaam, geboortedatum);
        this.coaMedewerker = coaMedewerker;

    }

    public boolean isCoaMedewerker() {
        return coaMedewerker;
    }

    public void setCoaMedewerker(boolean coaMedewerker) {
        this.coaMedewerker = coaMedewerker;
    }

    public void actieUitvoeren() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Deze rol heeft nog geen functies");

    }
        void registrerenVluchteling() {}

    void opvragenGemeente() {}

    void bijwerkenDossier() {}
}
