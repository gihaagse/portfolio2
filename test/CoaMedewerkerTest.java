import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CoaMedewerkerTest {

    @Test
    void registratieVoltooienAsielzoekerFalse() {
        CoaMedewerker coaMedewerker = new CoaMedewerker();
        Boolean asielzoekerBool = false;
        boolean paspoort = true;
        boolean familie = true;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coaMedewerker.registratieVoltooienPrint(asielzoekerBool, paspoort, familie);

        String expectedOutput = "Dit persoon is geen asielzoeker, dus de registratie is afgebroken";
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

        coaMedewerker.registratieVoltooienPrint(asielzoekerBool, paspoort, familie);

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

        coaMedewerker.registratieVoltooienPrint(asielzoekerBool, paspoort, familie);

        String expectedOutput = "Dit persoon heeft een paspoort, is geen familie en is een asielzoeker";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }
    @Test
    void registratieVoltooienAlleTrue() {
        CoaMedewerker coaMedewerker = new CoaMedewerker();
        Boolean asielzoekerBool = true;
        boolean paspoort = true;
        boolean familie = true;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coaMedewerker.registratieVoltooienPrint(asielzoekerBool, paspoort, familie);

        String expectedOutput = "Dit persoon heeft een paspoort, familie en is een asielzoeker.";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }

}