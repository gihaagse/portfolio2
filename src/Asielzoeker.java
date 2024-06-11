import java.time.LocalDate;
import java.util.Scanner;

public class Asielzoeker extends Gebruiker implements Observer, StdActies{
    private static final Scanner scanner = new Scanner(System.in);

    private boolean asielzoeker;
    private String adres;
    private Land landVanHerkomst;
    private Archief archief;
    private DossierEditor dossierEditor = new DossierEditor();


    public Asielzoeker(){}
    public Asielzoeker(String naam, String achternaam, LocalDate geboortedatum, boolean asielzoeker){
        super(naam, achternaam, geboortedatum);
        this.asielzoeker = asielzoeker;
    }


    public void setArchief(Archief archief){
        this.archief = this.archief;
    }

    @Override
    public Archief getArchief() {
        return archief;
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
        if (archief == null) {
            System.out.println("Het dossier is nog leeg");
        }
        else{
            dossierEditor.uitlezenArchief(archief);
        }
        KeuzeChecker.returnNaarHoofdmenu(this);

    }

    void registrerenNieuwAdres() {

        if(getArchief().getEigenWoning() == AfrondingWoning.OPGESTART) {
            System.out.println("Wat is uw nieuwe adres?");
            String nieuwAdres = scanner.nextLine();
            this.adres = nieuwAdres;

            System.out.println();
            System.out.println("Uw nieuwe adres is: " + adres + ".");

            getArchief().setEigenWoning(AfrondingWoning.AFGEROND);

            KeuzeChecker.returnNaarHoofdmenu(this);
        }
        else {
            System.out.println("De plaatsing in een eigen woning is nog niet opgestart, dus het nieuwe adres kan nog niet geregistreerd worden.");
            KeuzeChecker.returnNaarHoofdmenu(this);
        }
    }
    @Override
    public void update(){
        System.out.println(getNaam() + " " + getAchternaam() + ": Uw plaatsing in een eigen woning is opgestart.");
    }
    public static void main(String[] args) {
        Asielzoeker aslz = new Asielzoeker();
        aslz.actieUitvoeren();
    }


}