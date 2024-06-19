import java.util.ArrayList;

public class Familie {
    private String familienaam;
    private ArrayList<Asielzoeker> familieLeden = new ArrayList<>();

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public Familie(String familienaam){
        this.familienaam = familienaam;
    }

    public Familie(String familienaam, Asielzoeker asielzoeker){
        this.familienaam = familienaam;
        familieLeden.add(asielzoeker);
    }

    public ArrayList<Asielzoeker> getFamilieLeden() {
        return familieLeden;
    }

    public void setFamilieLeden(Asielzoeker familieLeden) {
        this.familieLeden.add(familieLeden);
    }
}
