import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList <Land> landen = new ArrayList<>();
    public static void main(String[] args) {

        Land voorbeeldLand1 = new Land ("Nederland", true);
        Land voorbeeldLand2 = new Land ("Afghanistan", false);
        landen.add(voorbeeldLand1);
        landen.add(voorbeeldLand2);
        Beheerder beheerder;
        CoaMedewerker coaMedewerker;
        Asielzoeker asielzoeker;

/*        Beheerder beheerder1 = new Beheerder("test", "testt", LocalDate.of(2004, 6, 27), true);
        beheerder1.veranderenVeiligheidLand();*/


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom in het programma");
        System.out.println();
        System.out.println("Wat is uw voornaam?");
        System.out.println("voornaam: ");
        String voornaam = scanner.nextLine();

        System.out.println();
        System.out.println("Wat is uw achternaam?");
        System.out.println("Achternaam: ");
        String achternaam = scanner.nextLine();

        System.out.println();
        System.out.println("Wat is uw geboortejaar?");
        System.out.println("Geboortejaar: ");
        int geboorteJaar = scanner.nextInt();

        System.out.println();
        System.out.println("Wat is uw geboortemaand? (in cijfers)");
        System.out.println("GeboorteMaand: ");
        int geboorteMaand = scanner.nextInt();

        System.out.println();
        System.out.println("Wat is uw geboortedag?");
        System.out.println("Geboortedag: ");
        int geboorteDag = scanner.nextInt();



        System.out.println();
        System.out.println("Welkom " + voornaam + " " + achternaam + ".");
        System.out.println("Kies uw rol:");
        System.out.println("1) Beheerder");
        System.out.println("2) COA-medewerker");
        System.out.println("3) Asielzoeker");
        int rol = KeuzeChecker.keuzeCheck(3);
        //scanner.nextLine();
        System.out.println();

        System.out.print("Uw rol is ");
        String rolnaam;

        if(rol == 1){
            rolnaam = "Beheerder";
            beheerder = new Beheerder(voornaam, achternaam, LocalDate.of(geboorteJaar, geboorteMaand, geboorteDag), true);
            System.out.println(rolnaam);
            System.out.println();
            beheerder.actieUitvoeren();
        }
        else if(rol == 2){
            rolnaam = "COA-medewerker";
            coaMedewerker = new CoaMedewerker(voornaam, achternaam, LocalDate.of(geboorteJaar, geboorteMaand, geboorteDag), true);
            System.out.println(rolnaam);
            System.out.println();
            coaMedewerker.actieUitvoeren();
        }
        else if(rol ==3){
            rolnaam = "Asielzoeker";
            asielzoeker = new Asielzoeker(voornaam, achternaam, LocalDate.of(geboorteJaar, geboorteMaand, geboorteDag), true);
            System.out.println(rolnaam);
            System.out.println();
            asielzoeker.actieUitvoeren();
        }



    }


}
