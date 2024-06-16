import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CoaMedewerkerTest {

    @Test
    void registratieVoltooienAlleTrue() {
        CoaMedewerker coaMedewerker = new CoaMedewerker();
        Boolean asielzoekerBool = true;
        boolean paspoort = true;
        boolean familie = true;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coaMedewerker.registratieVoltooien(asielzoekerBool, paspoort, familie);

        String expectedOutput = "De volgende gegevens zijn ingevuld in het dossier van de asielzoeker:";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }

    @Test
    void registratieVoltooienPaspoortFalse() {
        CoaMedewerker coaMedewerker = new CoaMedewerker();
        Boolean asielzoekerBool = true;
        boolean paspoort = false;
        boolean familie = true;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coaMedewerker.registratieVoltooien(asielzoekerBool, paspoort, familie);

        String expectedOutput = "De asielzoeker kan geen paspoort tonen, dus het dossier kan niet worden aangemaakt";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }

    @Test
    void registratieVoltooienFamilieFalse() {
        CoaMedewerker coaMedewerker = new CoaMedewerker();
        Boolean asielzoekerBool = true;
        boolean paspoort = true;
        boolean familie = false;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coaMedewerker.registratieVoltooien(asielzoekerBool, paspoort, familie);

        String expectedOutput = "De asielzoeker kan geen paspoort tonen, dus het dossier kan niet worden aangemaakt";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }

    @Test
    void registratieVoltooienAlleFalse() {
        CoaMedewerker coaMedewerker = new CoaMedewerker();
        Boolean asielzoekerBool = true;
        boolean paspoort = false;
        boolean familie = false;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coaMedewerker.registratieVoltooien(asielzoekerBool, paspoort, familie);

        String expectedOutput = "De asielzoeker kan geen paspoort tonen, dus het dossier kan niet worden aangemaakt";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);


    }
}