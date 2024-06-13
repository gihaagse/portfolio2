import java.util.Scanner;

public interface Observer {
    static final Scanner scanner = new Scanner(System.in);

    public void updateWoningOpgestart(Gebruiker asielzoeker);
    public void updateWoningAfgerond(Gebruiker asielzoeker);
    public Archief getArchief();
    public void setArchief(Archief archief);

}
