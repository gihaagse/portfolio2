import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<Land> landen = new ArrayList<>();
    public static ArrayList<Asielzoeker> asielZoekers = new ArrayList<>();
    public static ArrayList<Asielzoeker> ter_Apel = new ArrayList<>();
    public static ArrayList<CoaMedewerker> coaMedewerkers = new ArrayList<>();
    public static ArrayList<Beheerder> beheerders = new ArrayList<>();

    public static void main(String[] args) {

        Land voorbeeldLand1 = new Land("Nederland", true);
        Land voorbeeldLand2 = new Land("Afghanistan", false);
        Land voorbeeldLand3 = new Land("Oekraïne", false);
        landen.add(voorbeeldLand1);
        landen.add(voorbeeldLand2);
        landen.add(voorbeeldLand3);

        Beheerder beheerder;
        CoaMedewerker coaMedewerker;
        Asielzoeker asielzoeker;

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

        System.out.println("Wilt u een nieuwe gebruiker aanmaken voor deze rol of wilt u inloggen met een bestaand account?");
        System.out.println("1) Nieuwe gebruiker aanmaken");
        System.out.println("2) Inloggen met een bestaand account (Deze functie werkt niet)");
        int inlogKeuze = KeuzeChecker.keuzeCheck(2);

        if (inlogKeuze == 1) {
            switch (rol) {
                case 1:
                    beheerder = new Beheerder();
                    MaakUsers.nieuweGebruikerMaken(beheerder);
                    beheerders.add(beheerder);
                    beheerder.actieUitvoeren();
                    break;

                case 2:
                    coaMedewerker = new CoaMedewerker();
                    MaakUsers.nieuweGebruikerMaken(coaMedewerker);
                    coaMedewerkers.add(coaMedewerker);
                    coaMedewerker.actieUitvoeren();
                    break;

                case 3:
                    asielzoeker = new Asielzoeker();
                    MaakUsers.nieuweGebruikerMaken(asielzoeker);
                    asielZoekers.add(asielzoeker);
                    asielzoeker.actieUitvoeren();
                    break;

                default:
                    System.out.println("Geen rol");
                    break;
            }
        }
        else{

        }




    }


}



