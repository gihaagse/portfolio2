public interface Archief {
    void invullenStandaardArchief(Gebruiker asielzoeker);
    void uitlezenArchief(Asielzoeker asielzoeker);
    void subscribeArchiefUpdates(Observer observer);
    void unsubscribeArchiefUpdates(Observer observer);

    public AfrondingAsiel getAfrondingAsiel();

    public void setAfrondingAsiel(AfrondingAsiel afrondingAsiel);


    public UitspraakIND getUitspraakIND();


    public void setUitspraakIND(UitspraakIND uitspraakIND);


    public AfrondingWoning getEigenWoning();
    public void setEigenWoning(AfrondingWoning eigenWoning, Gebruiker asielzoeker);

    public TerugNaarLand getTerugNaarLand();

    public void setTerugNaarLand(TerugNaarLand terugNaarLand);


}
