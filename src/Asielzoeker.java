import java.time.LocalDate;
import java.util.Scanner;

public class Asielzoeker extends Gebruiker implements Observer{
    private boolean asielzoeker;
    private String adres;
    private Land landVanHerkomst;
    public Asielzoeker(){}
    public Asielzoeker(String naam, String achternaam, LocalDate geboortedatum, boolean asielzoeker){
        super(naam, achternaam, geboortedatum);
        this.asielzoeker = asielzoeker;

    }

    public boolean isAsielzoeker() {
        return asielzoeker;
    }

    public void setAsielzoeker(boolean asielzoeker) {
        this.asielzoeker = asielzoeker;
    }

    public Land getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public void actieUitvoeren() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat voor actie wilt u uitvoeren?");

        System.out.println("(Voorlopig alleen deze optie)");
        System.out.println("1) Nieuw adres registreren");

        int keuze = KeuzeChecker.keuzeCheck(1);

        if (keuze == 1) {
            registrerenNieuwAdres();
        }
    }


    void gegevensOpvragen() {}

    void opvragenStatusDossier() {}

    void registrerenNieuwAdres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat is uw nieuwe adres?");
        String nieuwAdres = scanner.nextLine();
        this.adres = nieuwAdres;

        System.out.println();
        System.out.println("Uw nieuwe adres is: " + adres + ".");

        System.out.println("Wilt u nog een actie uitvoeren of teruggaan naar het inlogscherm?");
        System.out.println("1) Nog een actie uitvoeren");
        System.out.println("2) Teruggaan naar het inlogscherm");
        int afloopKeuze = KeuzeChecker.keuzeCheck(2);

        if (afloopKeuze == 1) {
            actieUitvoeren();
        } else {
            Main.main(null);
        }
    }
    @Override
    public void update(){
        System.out.println("Het dossier is geüpdate");
    }
}