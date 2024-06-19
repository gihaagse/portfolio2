import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Land> landen = new ArrayList<>();
    public static ArrayList<Gebruiker> asielzoekers = new ArrayList<>();
    public static ArrayList<Gebruiker> ter_Apel = new ArrayList<>();
    public static ArrayList<Gebruiker> coaMedewerkers = new ArrayList<>();
    public static ArrayList<Gebruiker> beheerders = new ArrayList<>();
    public static ArrayList<Familie> families = new ArrayList<>();
    private static Boolean eersteKeer = true;
    private static DossierEditor dossierEditor = new DossierEditor();



    public static void main(String[] args) {

        if(eersteKeer) {
            maakVoorbeelden();
            eersteKeer = false;
        }

        int rol = startupKeuze();

        int inlogKeuze = inlogKeuze();

        if (inlogKeuze == 1) {
            switch (rol) {
                case 1:
                    beheerderUitvoeren();
                    break;

                case 2:
                    coaMedewerkerUitvoeren();
                    break;

                case 3:
                    asielzoekerUitvoeren();
                    break;

                default:
                    System.out.println("Geen rol");
                    break;
            }
        }

        else{
            System.out.println("Voer het nummer in van het account waarmee u wilt inloggen");
            switch (rol){
                case 1:
                    KeuzeChecker.printLijstVanGebruikers(beheerders);
                    KeuzeChecker.kiesGebruiker(beheerders);
                    break;
                case 2:
                    KeuzeChecker.printLijstVanGebruikers(coaMedewerkers);
                    KeuzeChecker.kiesGebruiker(coaMedewerkers);
                    break;
                case 3:
                    KeuzeChecker.printLijstVanGebruikers(asielzoekers);
                    KeuzeChecker.kiesGebruiker(asielzoekers);
                    break;
                default:
                    System.out.println("Geen optie");
                    break;
            }

        }




    }
    public static void maakVoorbeelden(){
        Land voorbeeldLand1 = new Land("Nederland", true);
        Land voorbeeldLand2 = new Land("Afghanistan", false);
        Land voorbeeldLand3 = new Land("Oekraïne", false);
        landen.add(voorbeeldLand1);
        landen.add(voorbeeldLand2);
        landen.add(voorbeeldLand3);

        Beheerder voorbeeldBeheerder1 = new Beheerder("Bob", "Pieters", LocalDate.of(1977, 4, 8), true);
        beheerders.add(voorbeeldBeheerder1);

        Asielzoeker voorbeeldAsielzoeker1 = new Asielzoeker("Tak", "Lak", LocalDate.of(1980, 8, 20), true);
        Asielzoeker voorbeeldAsielzoeker2 = new Asielzoeker("Pita", "Zaki", LocalDate.of(1975, 4, 25), true);
        Asielzoeker voorbeeldAsielzoeker3 = new Asielzoeker("Maki", "Zehn", LocalDate.of(1999, 3, 2), true);
        Dossier dossier1 = new Dossier();
        Dossier dossier2 = new Dossier();
        Dossier dossier3 = new Dossier();
        DossierEditor.invullenStandaardArchief(dossier1, voorbeeldAsielzoeker1);
        DossierEditor.invullenStandaardArchief(dossier2, voorbeeldAsielzoeker2);
        DossierEditor.invullenStandaardArchief(dossier3, voorbeeldAsielzoeker3);
        asielzoekers.add(voorbeeldAsielzoeker1);
        asielzoekers.add(voorbeeldAsielzoeker2);
        asielzoekers.add(voorbeeldAsielzoeker3);
        dossierEditor.subscribeArchiefUpdates(dossier1, voorbeeldAsielzoeker1);
        dossierEditor.subscribeArchiefUpdates(dossier2, voorbeeldAsielzoeker2);
        dossierEditor.subscribeArchiefUpdates(dossier3, voorbeeldAsielzoeker3);

        CoaMedewerker voorbeeldCoaMedewerker1 = new CoaMedewerker("Coa", "Lita", LocalDate.of(1984, 7, 21), true);
        coaMedewerkers.add(voorbeeldCoaMedewerker1);

        Familie familie1 = new Familie("Jotti", voorbeeldAsielzoeker1);
        Familie familie2 = new Familie("Laka", voorbeeldAsielzoeker2);
        Familie familie3 = new Familie("Zaraki", voorbeeldAsielzoeker3);
        families.add(familie1);
        families.add(familie2);
        families.add(familie3);

    }

    public static int startupKeuze(){
        System.out.println();
        System.out.println("Welkom in het programma");
        System.out.println();

        System.out.println("Kies uw rol:");
        System.out.println("1) Beheerder");
        System.out.println("2) COA-medewerker");
        System.out.println("3) Asielzoeker");
        int rol = KeuzeChecker.keuzeCheck(3);
        System.out.println();

        System.out.print("Uw rol is ");
        KeuzeChecker.printRol(rol);
        System.out.println();

        return rol;
    }

    public static int inlogKeuze(){
        System.out.println("Wilt u een nieuwe gebruiker aanmaken voor deze rol of wilt u inloggen met een bestaand account?");
        System.out.println("1) Nieuwe gebruiker aanmaken");
        System.out.println("2) Inloggen met een bestaand account (Voor nu kiezen uit lijst)");
        int inlogKeuze = KeuzeChecker.keuzeCheck(2);

        return inlogKeuze;
    }

    public static void beheerderUitvoeren(){
        Beheerder beheerder = new Beheerder();
        MaakUsers.nieuweGebruikerMaken(beheerder);
        beheerders.add(beheerder);
        beheerder.actieUitvoeren();
    }

    public static void coaMedewerkerUitvoeren(){
        CoaMedewerker coaMedewerker = new CoaMedewerker();
        MaakUsers.nieuweGebruikerMaken(coaMedewerker);
        coaMedewerkers.add(coaMedewerker);
        coaMedewerker.actieUitvoeren();
    }

    public static void asielzoekerUitvoeren(){
        Asielzoeker asielzoeker = new Asielzoeker();
        MaakUsers.nieuweGebruikerMaken(asielzoeker);
        Archief archief = new Dossier();
        DossierEditor.setArchief(archief, asielzoeker);
        asielzoekers.add(asielzoeker);
        archief.subscribeArchiefUpdates(asielzoeker);
        asielzoeker.actieUitvoeren();
    }
}



