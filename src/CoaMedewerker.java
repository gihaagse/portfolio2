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
        System.out.println("2) Dossier aanpassen (niet de volledige user story, alleen simpele aanpassingen om udpates vanaf het dossier aan te tonen)");
        System.out.println();

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

        KeuzeChecker.returnNaarHoofdmenu(this);



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
                DossierEditor.invullenStandaardArchief(archief, asielzoeker);
                dossierEditor.subscribeArchiefUpdates(archief, asielzoeker);
                System.out.println();
                System.out.println("De volgende gegevens zijn ingevuld in het dossier van de asielzoeker:");
                dossierEditor.uitlezenArchief(archief);
                break;
            case 2:
                System.out.println();
                System.out.println("De asielzoeker kan geen paspoort tonen, dus het dossier kan niet worden aangemaakt");
                break;
            default:
                System.out.println("Geen keuze");
                break;
        }

    }

    @Override
    public void updateWoningOpgestart(Gebruiker asielzoeker) {
        System.out.println();
        System.out.println("UPDATE MELDING (Coa Medewerker): ");
        System.out.println("De plaatsing in een eigen woning van " + asielzoeker.getNaam() + " " + asielzoeker.getAchternaam() + " is opgestart." );
    }

    @Override
    public void updateWoningAfgerond(Gebruiker asielzoeker) {
        System.out.println();
        System.out.println("UPDATE MELDING (Coa Medewerker): ");
        System.out.println("De plaatsing in een eigen woning van " + asielzoeker.getNaam() + " " + asielzoeker.getAchternaam() + " is afgerond.");

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
        System.out.println();
        KeuzeChecker.printLijstVanGebruikers(Main.asielzoekers);
        int keuze = KeuzeChecker.keuzeCheck(Main.asielzoekers.size());
        Gebruiker gekozenAsielzoeker = Main.asielzoekers.get(keuze-1);


        Archief archief = gekozenAsielzoeker.getArchief();

        System.out.println();
        System.out.println("Dit is het huidige dossier van " + gekozenAsielzoeker.getNaam() + " " + gekozenAsielzoeker.getAchternaam() + ": ");
        gekozenAsielzoeker.opvragenStatusDossier();

        System.out.println();
        System.out.println("Welk detail wilt u veranderen?");
        System.out.println("1) Asiel afronding");
        System.out.println("2) Uitspraak IND");
        System.out.println("3) Plaatsing in eigen woning");
        System.out.println("4) Terrugkering naar land van herkomst");
        System.out.println();

        int detailKeuze = KeuzeChecker.keuzeCheck(4);

        System.out.println("Waar wilt u het naar veranderen?");

        switch (detailKeuze){
            case 1:
                System.out.println("1) " + AfrondingAsiel.JA);
                System.out.println("2) " + AfrondingAsiel.NEE);

                int asielKeuze = KeuzeChecker.keuzeCheck(2);
                    switch (asielKeuze){
                        case 1:
                            DossierEditor.setAfrondingAsiel(archief, AfrondingAsiel.JA);
                        break;
                        case 2:
                            DossierEditor.setAfrondingAsiel(archief, AfrondingAsiel.NEE);
                        break;
                        default:
                            System.out.println();
                            System.out.println("Deze optie is er niet");
                            break;
                    }

                break;
            case 2:
                System.out.println("1) " + UitspraakIND.JA);
                System.out.println("2) " + UitspraakIND.NEE);
                int indUitspraakKeuze = KeuzeChecker.keuzeCheck(2);
                switch (indUitspraakKeuze){
                    case 1:
                        DossierEditor.setUitspraakIND(archief, UitspraakIND.JA);
                        break;
                    case 2:
                        DossierEditor.setUitspraakIND(archief, UitspraakIND.NEE);
                        break;
                    default:
                        System.out.println();
                        System.out.println("Deze optie is er niet");
                        break;
                }
                break;
            case 3:
                System.out.println("1) " + AfrondingWoning.AFGEROND);
                System.out.println("2) " + AfrondingWoning.OPGESTART);
                System.out.println("3) " + AfrondingWoning.NEE);
                int afrondingWoningKeuze = KeuzeChecker.keuzeCheck(3);
                switch (afrondingWoningKeuze){
                    case 1:
                        DossierEditor.setEigenWoning(archief, AfrondingWoning.AFGEROND, asielzoeker);
                        break;
                    case 2:
                        DossierEditor.setEigenWoning(archief, AfrondingWoning.OPGESTART, asielzoeker);
                        break;
                    case 3:
                        DossierEditor.setEigenWoning(archief, AfrondingWoning.NEE, asielzoeker);
                        break;
                    default:
                        System.out.println();
                        System.out.println("Deze optie is er niet");
                        break;
                }
                break;
            case 4:
                System.out.println("1) " + TerugNaarLand.JA);
                System.out.println("2) " + TerugNaarLand.NEE);
                int terugNaarLandKeuze = KeuzeChecker.keuzeCheck(2);
                switch (terugNaarLandKeuze){
                    case 1:
                        DossierEditor.setTerugNaarLand(archief, TerugNaarLand.JA);
                        break;
                    case 2:
                        DossierEditor.setTerugNaarLand(archief, TerugNaarLand.NEE);
                        break;
                    default:
                        System.out.println();
                        System.out.println("Deze optie is er niet");
                        break;
                }
                break;
            default:
                System.out.println();
                System.out.println("Deze optie is er niet");
                break;

        }

    }


    public static void main(String[] args) {
        CoaMedewerker coaMed = new CoaMedewerker();
        coaMed.actieUitvoeren();
    }

}
