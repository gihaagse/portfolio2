import java.util.Scanner;

public class KeuzeChecker {
    private static final Scanner scanner = new Scanner(System.in);
    public static int keuzeCheck (int max) {
        while (true) {

            if (scanner.hasNextInt()) {
                int gekozenOptie = scanner.nextInt();
                if (gekozenOptie <= max && gekozenOptie >= 1)  {
                    return gekozenOptie;
                } else {
                    System.out.println("Selecteer alstublieft een geldig nummer (1 t/m " +max+ "):");
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
                System.out.println("Ongeldige invoer. Voer een warde in tussen " + min + " en " + max );
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
}
