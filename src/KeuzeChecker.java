import java.util.Scanner;

public class KeuzeChecker {

    public static int keuzeCheck (int max) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
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
}
