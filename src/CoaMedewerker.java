import java.time.LocalDate;

public class CoaMedewerker extends Gebruiker implements Observer, StdActies{
    private boolean coaMedewerker;
    private DossierEditor dossierEditor = new DossierEditor();
    private Asielzoeker asielzoeker;

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
        System.out.println("1) Vluchteling registreren");
        System.out.println("2) Dossier aanpassen (simpele functie)");

        int keuze = KeuzeChecker.keuzeCheck(2);

        switch (keuze) {
            case 1:
                registrerenVluchteling();
                break;
            case 2:
                bijwerkenDossier();
                break;
            default:
                System.out.println("Deze keuze is er niet");;
                break;
        }


    }




    public void registrerenVluchteling() {
        System.out.println("U heeft gekozen voor het registreren van een vluchteling.");
        System.out.println("Voer alstublieft de volgende gegevens in van de vluchteling");
        System.out.println();

        asielzoeker = new Asielzoeker();
        MaakUsers.nieuweGebruikerMaken(asielzoeker);
        Archief archief = new Dossier();
        asielzoeker.setArchief(archief);
        Main.asielzoekers.add(asielzoeker);

        System.out.println("Kan de betreffende asielzoeker een paspoort tonen?");
        System.out.println("1) Ja");
        System.out.println("2) Nee");
        int keuze = KeuzeChecker.keuzeCheck(2);

        switch (keuze){
            case 1:
                DossierEditor.invullenStandaardArchief(archief);
                dossierEditor.subscribeArchiefUpdates(archief, asielzoeker);
                System.out.println("De volgende gegevens zijn ingevuld in het dossier van de asielzoeker:");
                dossierEditor.uitlezenArchief(archief);
            case 2:
                System.out.println("De asielzoeker kan geen paspoort tonen, dus het dossier kan niet worden aangemaakt");
                break;
            default:
                System.out.println("Geen keuze");
                break;
        }

        KeuzeChecker.returnNaarHoofdmenu(this);
    }

    @Override
    public void update() {
        System.out.println("De plaatsing in een eigen woning van " + asielzoeker.getNaam() + " " + asielzoeker.getAchternaam() + "opgestart." );
    }

    @Override
    public Dossier getArchief() {
        return null;
    }

    @Override
    public void setArchief(Archief archief) {

    }

    void opvragenGemeente() {}

    void bijwerkenDossier() {
        System.out.println("U heeft gekozen voor het aanpassen van een dossier.");
        System.out.println("Welk dossier wilt u aanpassen?");
        KeuzeChecker.printLijstVanGebruikers(Main.asielzoekers);
        int keuze = KeuzeChecker.keuzeCheck(Main.asielzoekers.size()) - 1;

        System.out.println();
        System.out.println("Dit is het huidige dossier van " + Main.asielzoekers.get(keuze).getNaam() + " " + Main.asielzoekers.get(keuze).getAchternaam() + ": ");
        Main.asielzoekers.get(keuze).opvragenStatusDossier();

        System.out.println();
        System.out.println("Welk detail wilt u veranderen?");
        System.out.println("1) Asiel afronding");
        System.out.println("2) Uitspraak IND");
        System.out.println("3)Plaatsing in eigen woning");
        System.out.println("4) Terrugkering naar land van herkomst");

        int detailKeuze = KeuzeChecker.keuzeCheck(4);

        switch (detailKeuze){
            case 1:
                System.out.println("Waar wilt u het naar veranderen?");
                System.out.println(AfrondingAsiel.NEE);

        }

    }
}
