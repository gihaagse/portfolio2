import java.time.LocalDate;
import java.util.Scanner;

public class Asielzoeker extends Gebruiker implements Observer, StdActies{
    private boolean asielzoeker;
    private String adres;
    private Land landVanHerkomst;
    private Dossier dossier;


    public Asielzoeker(){}
    public Asielzoeker(String naam, String achternaam, LocalDate geboortedatum, boolean asielzoeker){
        super(naam, achternaam, geboortedatum);
        this.asielzoeker = asielzoeker;

    }


    @Override
    public void setDossier(Dossier dossier){
        this.dossier = dossier;
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
    @Override
    public void actieUitvoeren() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat voor actie wilt u uitvoeren?");

        System.out.println("(Voorlopig alleen deze optie)");
        System.out.println("1) Nieuw adres registreren");
        System.out.println("2) Status van dossier inzien");

        int keuze = KeuzeChecker.keuzeCheck(2);

        switch (keuze) {
            case 1:
                registrerenNieuwAdres();
                break;
            case 2:
                opvragenStatusDossier();
                break;
            default:
                System.out.println("Deze keuze is er niet");
                break;
        }

    }


    void gegevensOpvragen() {}

    void opvragenStatusDossier() {
        System.out.println("Asielaanvraag is afgerond: " + dossier.isAfrondingAsiel());
        System.out.println("Uitspraak IND: " + dossier.isUitspraakIND());
        System.out.println("Plaatsing in eigen woning: " + dossier.getEigenWoning());
        System.out.println("Teruggekeerd naar het land van herkomst: " + dossier.isTerugNaarLand());
    }

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
        KeuzeChecker.returnNaarHoofdmenu(afloopKeuze, this);

    }
    @Override
    public void update(){
        System.out.println("Het dossier is geüpdate");
    }
    public void main(String[] args) {
        Asielzoeker aslz = new Asielzoeker();
        actieUitvoeren();
    }
}