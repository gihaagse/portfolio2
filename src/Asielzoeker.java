import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;

public class Asielzoeker extends Gebruiker implements Observer, StdActies{
    private static final Scanner scanner = new Scanner(System.in);

    private boolean asielzoeker;
    private Woonplaats adres;
    private Land landVanHerkomst;
    private Archief archief;
    private DossierEditor dossierEditor = new DossierEditor();
    private Familie familie;
    private LocalDate geboorteDatum;


    public Asielzoeker(){}
    public Asielzoeker(String naam, String achternaam, LocalDate geboortedatum, boolean asielzoeker){
        super(naam, achternaam, geboortedatum);
        this.asielzoeker = asielzoeker;
    }

    public void setArchief(Archief archief){
        this.archief = archief;
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

    public Woonplaats getAdres(){
        return this.adres;
    }

    public void setAdres(Woonplaats adres){
        this.adres = adres;
    }

    public Land getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public int getLeeftijd() {
        if (geboorteDatum != null) {
            LocalDate currentDate = LocalDate.now();
            return Period.between(geboorteDatum, currentDate).getYears();
        }
        else {
            return -1;
        }
    }

    public void printLevensFase(int leeftijd){
        System.out.print("De asielzoeker is een: ");
        if (leeftijd <= 17) {
            System.out.println("Kind");
        }
        else if (leeftijd <= 64) {
            System.out.println("Volwassene");
        }
        else {
            System.out.println("Oudere");
        }

    }



    @Override
    public void actieUitvoeren() {
        System.out.println();
        System.out.println("Wat voor actie wilt u uitvoeren?");
        System.out.println("1) Nieuw adres registreren");
        System.out.println("2) Status van dossier inzien");
        System.out.println();

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

        KeuzeChecker.returnNaarHoofdmenu(this);


    }


    void gegevensOpvragen() {}

    @Override
    void opvragenStatusDossier() {
        if (archief == null) {
            System.out.println("Het dossier is nog leeg");
        }
        else{
            dossierEditor.uitlezenArchief(archief);
        }

    }

    void registrerenNieuwAdres() {

        if(getArchief().getEigenWoning() == AfrondingWoning.OPGESTART) {
            System.out.println("Het proces van de plaatsing in een eigen woning is opgestart, dus u kunt het nieuwe adres registreren.");
            System.out.println("Wat is uw nieuwe adres?");
            String nieuwAdres = scanner.nextLine();
            System.out.println();

            System.out.println("In welke stad ligt dat?");
            String stad = scanner.nextLine();
            System.out.println();

            System.out.println("Wat is de postcode?");
            String postcode = scanner.nextLine();
            System.out.println();

            setAdres(new Woonplaats(nieuwAdres, stad, postcode));

            System.out.println();
            System.out.println("Uw nieuwe adres is: " + adres + ".");

            getArchief().setEigenWoning(AfrondingWoning.AFGEROND, this);

        }
        else {
            System.out.println();
            System.out.println("De plaatsing in een eigen woning is nog niet opgestart, dus het nieuwe adres kan nog niet geregistreerd worden.");
        }
    }
    @Override
    public void updateWoningOpgestart(Gebruiker asielzoeker){
        System.out.println();
        System.out.println("UPDATE MELDING (Asielzoeker): ");
        System.out.println(getNaam() + " " + getAchternaam() + ": Uw plaatsing in een eigen woning is opgestart.");
    }

    @Override
    public void updateWoningAfgerond(Gebruiker asielzoeker) {
        System.out.println();
        System.out.println("UPDATE MELDING: (Asielzoeker): ");
        System.out.println(getNaam() + " " + getAchternaam() + ": Uw plaatsing in een eigen woning is voltooid.");
    }

    public static int toelatingskansBerekenen(Gender gender, boolean isAsielzoeker, boolean heeftFamilie, int leeftijd) {
        int score = 0;


            switch (gender) {
                case VROUW:
                    score += 4;
                    break;
                case MAN:
                    score += 3;
                    break;
                case GEEN:
                    score += 1;
                    break;
                default:
                    score += 0;
                    break;
            }


        if (isAsielzoeker) {
            score += 1;
        }

        if (heeftFamilie) {
            score += 2;
        }

        if (leeftijd < 18) {
            score += 3;
        } else if (leeftijd >= 18) {
            score += 1;
        }

        return score;
    }


    public static void main(String[] args) {
        Asielzoeker aslz = new Asielzoeker();
        aslz.actieUitvoeren();
    }


}