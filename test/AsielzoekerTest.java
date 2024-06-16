import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AsielzoekerTest {

    @Test
    public void testLeeftijd0() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Asielzoeker asielzoeker = new Asielzoeker();
        asielzoeker.printLevensFase(0);

        String expectedOutput = "De asielzoeker is een: Kind";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testLeeftijd17() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Asielzoeker asielzoeker = new Asielzoeker();
        asielzoeker.printLevensFase(17);

        String expectedOutput = "De asielzoeker is een: Kind";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testLeeftijd18() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Asielzoeker asielzoeker = new Asielzoeker();
        asielzoeker.printLevensFase(18);

        String expectedOutput = "De asielzoeker is een: Volwassene";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testLeeftijd64() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Asielzoeker asielzoeker = new Asielzoeker();
        asielzoeker.printLevensFase(64);

        String expectedOutput = "De asielzoeker is een: Volwassene";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testLeeftijd65() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Asielzoeker asielzoeker = new Asielzoeker();
        asielzoeker.printLevensFase(65);

        String expectedOutput = "De asielzoeker is een: Oudere";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testToelatingskans1() {
        int score = Asielzoeker.toelatingskansBerekenen(Gender.MAN, true, true, 15);
        assertEquals(9, score);
    }
    @Test
    public void testToelatingskans2() {
        int score = Asielzoeker.toelatingskansBerekenen(Gender.MAN, false, false, 66);
        assertEquals(4, score);
    }
    @Test
    public void testToelatingskans3() {
        int score = Asielzoeker.toelatingskansBerekenen(Gender.VROUW, true, false, 6);
        assertEquals(8, score);
    }
    @Test
    public void testToelatingskans4() {
        int score = Asielzoeker.toelatingskansBerekenen(Gender.VROUW, false, true, 27);
        assertEquals(7, score);
    }
    @Test
    public void testToelatingskans5() {
        int score = Asielzoeker.toelatingskansBerekenen(Gender.GEEN, true, true, 22);
        assertEquals(5, score);
    }
    @Test
    public void testToelatingskans6() {
        int score = Asielzoeker.toelatingskansBerekenen(Gender.GEEN, false, false, 17);
        assertEquals(4, score);
    }

    

}