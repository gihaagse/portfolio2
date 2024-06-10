import java.time.LocalDate;

public class CoaMedewerker extends Gebruiker implements Observer, StdActies{
    private boolean coaMedewerker;
    private DossierEditor dossierEditor;
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
        System.out.println("Voer alstublieft de volgende gegevens in van de vluchteling");
        System.out.println();

        asielzoeker = new Asielzoeker();
        MaakUsers.nieuweGebruikerMaken(asielzoeker);
        Dossier dossier = new Dossier();
        asielzoeker.setDossier(dossier);
        Main.asielzoekers.add(asielzoeker);

        System.out.println("Kan de betreffende asielzoeker een paspoort tonen?");
        System.out.println("1) Ja");
        System.out.println("2) Nee");
        int keuze = KeuzeChecker.keuzeCheck(2);

        switch (keuze){
            case 1:
                DossierEditor.invullenStandaardArchief(dossier);
                dossierEditor.subscribeArchiefUpdates(dossier, asielzoeker);
                System.out.println("De volgende gegevens zijn ingevuld in het dossier van de asielzoeker:");
                dossierEditor.uitlezenArchief(dossier);
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
    public Dossier getDossier() {
        return null;
    }

    @Override
    public void setDossier(Dossier dossier) {

    }

    void opvragenGemeente() {}

    void bijwerkenDossier() {}
}
