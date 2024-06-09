import java.util.ArrayList;
import java.util.Scanner;

public class KeuzeChecker {
    private static final Scanner scanner = new Scanner(System.in);

    public static int keuzeCheck(int max) {
        while (true) {

            if (scanner.hasNextInt()) {
                int gekozenOptie = scanner.nextInt();
                if (gekozenOptie <= max && gekozenOptie >= 1) {
                    return gekozenOptie;
                } else {
                    System.out.println("Selecteer alstublieft een geldig nummer (1 t/m " + max + "):");
                }
            } else {
                System.out.println("Ongeldige invoer. Voer alstublieft een nummer in:");
                scanner.next();
            }
        }
    }

    public static int keuzeInRange(int min, int max) {
        int input;

        while (true) {
            input = scanner.nextInt();

            if (input >= min && input <= max) {
                return input;
            } else {
                System.out.println("Ongeldige invoer. Voer een warde in tussen " + min + " en " + max);
            }
        }
    }

    public static void printRol(int rol) {
        switch (rol) {
            case 1:
                System.out.println("Beheerder");
                break;
            case 2:
                System.out.println("COA-medewerker");
                break;
            case 3:
                System.out.println("Asielzoeker");
                break;
            default:
                System.out.println("Geen rol");
                break;
        }
    }

    public static void returnNaarHoofdmenu(StdActies stdactie) {
        System.out.println("Wilt u nog een actie uitvoeren of teruggaan naar het inlogscherm?");
        System.out.println("1) Nog een actie uitvoeren");
        System.out.println("2) Teruggaan naar het inlogscherm");
        int afloopKeuze = keuzeCheck(2);
        if (afloopKeuze == 1) {
            stdactie.actieUitvoeren();
        } else {
            Main.main(null);
        }

    }

    public static void printLijstVanGebruikers(ArrayList<Gebruiker> gebruiker){

        for(int i = 1; i <= gebruiker.size(); i++){
            System.out.println(i + ") " + gebruiker.get(i-1).getNaam() + " " + gebruiker.get(i-1).getAchternaam() );
        }
    }

    public static void kiesGebruiker(ArrayList<Gebruiker> gebruiker){
        int keuze = keuzeCheck(gebruiker.size()  );
        System.out.println(keuze);
        gebruiker.get(keuze-1).actieUitvoeren();
    }
}
