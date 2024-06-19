public class Land  {
    private String naam;
    private boolean veilig;

    public Land (String naam, boolean veilig){
        this.naam = naam;
        this.veilig = veilig;

    }
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean getVeiligheid() {
        return veilig;
    }

    public void setVeiligheid(boolean veiligheid) {
        this.veilig = veiligheid;
    }

    void wijzigenVeiligheidLand() {}
}