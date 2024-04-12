public class Asielzoeker extends Gebruiker {
    private boolean asielzoeker;
    private Land landVanHerkomst;

    public boolean isAsielzoeker() {
        return asielzoeker;
    }

    public void setAsielzoeker(boolean asielzoeker) {
        this.asielzoeker = asielzoeker;
    }

    public Land getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    void gegevensOpvragen() {}

    void opvragenStatusDossier() {}

    void registrerenNieuwAdres() {}
}