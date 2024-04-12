public class Beheerder extends Gebruiker {
    private boolean admin;
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    void toevoegenLand() {}

    void toevoegenGemeente() {}

    void beherenAZC() {}

    void rapportageOpvragen() {}
}
