import java.util.Scanner;

public interface Observer {
    static final Scanner scanner = new Scanner(System.in);


    public void update();

    public void setDossier(Dossier dossier);

}
