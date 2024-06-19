import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Beheerder extends Gebruiker {
    private boolean admin = true;

    public Beheerder(String naam, String achternaam, LocalDate geboortedatum, boolean admin){
        super(naam, achternaam, geboortedatum);
        this.admin = admin;

    }

    public Beheerder(){
    }
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void actieUitvoeren() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat voor actie wilt u uitvoeren?");

        System.out.println("1) Een land toevoegen");
        System.out.println("2) De veiligheid van een land veranderen");
        System.out.println();
        int actieBeheerder = KeuzeChecker.keuzeCheck(2);

        if (actieBeheerder == 1) {
            toevoegenLand();
        }

        else if (actieBeheerder == 2) {
            veranderenVeiligheidLand();
        }
    }


    public void toevoegenLand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Wat is de naam van het land dat u wilt toevoegen?");
        System.out.println("Land:");
        String landNaam = scanner.nextLine();

        System.out.println();
        System.out.println("Is dit land veilig of onveilig?");
        System.out.println("1) veilig");
        System.out.println("2) onveilig");
        int veiligheid = KeuzeChecker.keuzeCheck(2);
        //scanner.nextLine();

        boolean veilig = true;
        if (veiligheid == 1) {
            veilig = true;
        } else if (veiligheid == 2) {
            veilig = false;
        }

        Land land = new Land(landNaam, veilig);
        Main.landen.add(land);

        System.out.println();
        System.out.print("U heeft " + landNaam + " toegevoegd met veiligheid: ");
        if (veilig){
            System.out.println("veilig.");
        }
        else{
            System.out.println("onveilig.");
        }

        System.out.println();
        System.out.println("Wilt u nog een actie uitvoeren of teruggaan naar het inlogscherm?");
        System.out.println("1) Nog een actie uitvoeren");
        System.out.println("2) Teruggaan naar het inlogscherm");
        int afloopKeuze = KeuzeChecker.keuzeCheck(2);

        if (afloopKeuze == 1) {
            actieUitvoeren();
        } else {
            Main.main(null);
        }
    }

    void veranderenVeiligheidLand() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Van welk land wilt u de veiligheid veranderen?");
        ArrayList<Integer> landNummer = new ArrayList<>();

        for (int i = 0; i < Main.landen.size(); i++) {
            System.out.println((i + 1) + ": " + Main.landen.get(i).getNaam());
        }
        System.out.println();
        String land;

        while (true) {
            System.out.println("Voer een land in:");
            land = scanner.nextLine();

            for (int i = 0; i < Main.landen.size(); i++) {
                if (Main.landen.get(i).getNaam().equalsIgnoreCase(land)) {
                    landNummer.add(i);
                    //System.out.println(landNummer);

                }

                if (!landNummer.isEmpty()) {
                    System.out.println();
                    System.out.print("De huidige veiligheid van " + Main.landen.get(i).getNaam() + " = ");
                    if (Main.landen.get(i).getVeiligheid()) {
                        System.out.println("veilig");
                    } else {
                        System.out.println("onveilig");
                    }
                    System.out.println("Wat is de nieuwe veiligheid?");
                    System.out.println("1) veilig");
                    System.out.println("2) onveilig");

                    int nieuweVeiligheid = KeuzeChecker.keuzeCheck(2);
                    if (nieuweVeiligheid == 1) {
                        Main.landen.get(i).setVeiligheid(true);
                    } else {
                        Main.landen.get(i).setVeiligheid(false);
                    }

                    System.out.println();
                    System.out.print("De nieuwe veiligheid van " + Main.landen.get(i).getNaam() + " = ");
                    if (Main.landen.get(i).getVeiligheid()) {
                        System.out.println("veilig");
                    } else {
                        System.out.println("onveilig");
                    }


                    System.out.println("Wilt u nog een actie uitvoeren of teruggaan naar het inlogscherm?");
                    System.out.println("1) Nog een actie uitvoeren");
                    System.out.println("2) Teruggaan naar het inlogscherm");
                    int afloopKeuze = KeuzeChecker.keuzeCheck(2);

                    if (afloopKeuze == 1) {
                        actieUitvoeren();
                    } else {
                        Main.main(null);
                    }

                }

            }
            if (landNummer.isEmpty()) {
                System.out.println();
                System.out.println("Dit land staat nog niet geregistreerd");
            }
        }
    }

}
